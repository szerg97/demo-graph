package com.szalai.demograph.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class Acquaintance {
    @RelationshipId
    private Long id;
    @TargetNode
    private Person person;
    private Integer since;

    public Acquaintance(Person person, Integer since) {
        this.person = person;
        this.since = since;
    }
}
