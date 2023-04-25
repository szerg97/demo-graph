package com.szalai.demograph.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Person")
@NoArgsConstructor
public class Person {
    @Id
    private String name;
    private Integer born;

    public Person(String name, Integer born) {
        this.name = name;
        this.born = born;
    }
}
