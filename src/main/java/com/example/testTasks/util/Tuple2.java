package com.example.testTasks.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Tuple2<P, T> {
    private P firstField;
    private T secondField;

    public Tuple2(P firstField, T secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    public Tuple2() {}
}
