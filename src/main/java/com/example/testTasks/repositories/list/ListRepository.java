package com.example.testTasks.repositories.list;

import com.example.testTasks.entities.list.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListEntity, Long> {
}
