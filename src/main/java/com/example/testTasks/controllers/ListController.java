package com.example.testTasks.controllers;

import com.example.testTasks.dto.list.CreatListRequest;
import com.example.testTasks.dto.list.List;
import com.example.testTasks.dto.list.UpdateListRequest;
import com.example.testTasks.services.list.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lists")
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;

    @PostMapping()
    public List createList(@Valid @RequestBody CreatListRequest req) {
        return listService.createList(req);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getList(@PathVariable Long id) {
        return listService.getList(id);
    }

    @GetMapping()
    public ResponseEntity<?> getLists() {
        return new ResponseEntity<>(listService.getLists(), HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<List> updateList(@Valid @RequestBody UpdateListRequest req) {
        return listService.updateList(req);
    }
}
