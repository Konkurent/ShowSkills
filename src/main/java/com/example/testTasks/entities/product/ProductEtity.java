package com.example.testTasks.entities.product;

import com.example.testTasks.entities.list.ListEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEtity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

    private Integer kcal;

    @ManyToOne
    private ListEntity list;
}
