package com.szalai.demograph.repository;

import com.szalai.demograph.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, String> {
    Movie findByTitle(String title);
}
