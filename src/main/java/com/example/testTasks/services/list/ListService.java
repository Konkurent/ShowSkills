package com.example.testTasks.services.list;

import com.example.testTasks.dto.list.CreatListRequest;
import com.example.testTasks.dto.list.List;
import com.example.testTasks.dto.list.UpdateListRequest;
import com.example.testTasks.dto.product.Product;
import com.example.testTasks.entities.list.ListEntity;
import com.example.testTasks.entities.product.ProductEtity;
import com.example.testTasks.repositories.list.ListRepository;
import com.example.testTasks.util.Tuple2;
import com.example.testTasks.util.convertors.ListDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.testTasks.util.convertors.ListDTOConverter.toDto;

@Service
@Valid
@RequiredArgsConstructor
public class ListService {
    private final ListRepository listRepository;

    public ResponseEntity<?> getList(Long id) {
        return listRepository.findById(id)
                .map(l -> new Tuple2<>(ListDTOConverter.toDto(l), sumkCalProducts(l.getProducts())))
                .map(t -> new ResponseEntity(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    public java.util.List<Tuple2<List, Integer>> getLists() {
        return listRepository.findAll().stream()
                .map(l -> new Tuple2<>(ListDTOConverter.toDto(l), sumkCalProducts(l.getProducts())))
                .collect(Collectors.toList());
    }

    private Integer sumkCalProducts(java.util.List<ProductEtity> products) {
        return products.stream().mapToInt(ProductEtity::getKcal).sum();
    }

    @Transactional(rollbackFor = Exception.class)
    public List createList(CreatListRequest req) {
        ListEntity list = ListEntity.builder()
                .name(req.getName())
                .build();

        list.setProducts(Optional.ofNullable(req.getCreateProductRequests()).stream()
                .flatMap(Collection::stream)
                .map(p -> ProductEtity.builder()
                        .name(p.getName())
                        .description(p.getDescription())
                        .kcal(p.getKcal())
                        .list(list)
                        .build())
                .collect(Collectors.toList()));

        return toDto(listRepository.save(list));
    }

    public void addProductsToList(@NotNull ListEntity listEntity, @Nullable java.util.List<Product> products) {
        listEntity.getProducts().addAll(Optional.ofNullable(products).stream()
                .flatMap(Collection::stream)
                .map(p -> ProductEtity.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .description(p.getDescription())
                        .kcal(p.getKcal())
                        .list(listEntity)
                        .build())
                .collect(Collectors.toList()));
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<List> updateList(UpdateListRequest req) {
        ListEntity list = listRepository.findById(req.getId()).orElse(null);

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!req.getName().isBlank()) {
            list.setName(req.getName());
        }

        addProductsToList(list, req.getProductList());

        return new ResponseEntity<>(toDto(listRepository.save(list)), HttpStatus.OK);
    }
}
