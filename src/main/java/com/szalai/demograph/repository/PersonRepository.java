package com.szalai.demograph.repository;

import com.szalai.demograph.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, String> {
    Person findByName(String name);
}
