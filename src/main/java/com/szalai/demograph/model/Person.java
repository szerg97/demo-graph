package com.szalai.demograph.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@Node("Person")
@NoArgsConstructor
public class Person {
    @Id
    private String name;
    private Integer born;
    @Relationship(type = "KNOWS", direction = Relationship.Direction.INCOMING)
    private List<Acquaintance> acquaintances = new ArrayList<>();

    public Person(String name, Integer born) {
        this.name = name;
        this.born = born;
    }

    public void addAcquaintance(Acquaintance acq){
        acquaintances.add(acq);
    }
}
