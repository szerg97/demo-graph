package com.szalai.demograph.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Data
@RelationshipProperties
public class Roles {
    @RelationshipId
    private Long id;
    @TargetNode
    private final Person person;
    private final List<String> roles;

    public Roles(Person person, List<String> roles) {
        this.person = person;
        this.roles = roles;
    }
}
