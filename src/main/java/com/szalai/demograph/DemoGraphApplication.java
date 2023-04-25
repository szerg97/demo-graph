package com.szalai.demograph;

import com.szalai.demograph.model.Movie;
import com.szalai.demograph.model.Person;
import com.szalai.demograph.model.Roles;
import com.szalai.demograph.repository.MovieRepository;
import com.szalai.demograph.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class DemoGraphApplication {

    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public DemoGraphApplication(MovieRepository movieRepository, PersonRepository personRepository) {
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoGraphApplication.class, args);
    }

    @PostConstruct
    public void seed(){
        if (personRepository.findAll().isEmpty()){
            Person george = createPerson("George Lucas",1957);
            Person ewan = createPerson("Ewan McGregor",1978);
            Person jackson = createPerson("Samuel L Jackson",1963);
            Person ford = createPerson("Harrison Ford",1961);

            Movie starWars = createMovie(
                    "Star Wars III.",
                    "Description of SW III.",
                    List.of(george),
                    List.of(new Roles(ewan, List.of("Obi-Wan Kenobi")),
                            new Roles(jackson, List.of("Mace Windu"))));

            Movie indianaJones = createMovie(
                    "Indiana Jones I.",
                    "Description of IJ I.",
                    List.of(george),
                    List.of(new Roles(ford, List.of("Indiana Jones"))));

            personRepository.saveAll(List.of(george, ewan, jackson, ford));
            movieRepository.saveAll(List.of(starWars, indianaJones));
            log.info("Successfully inserted new records...");
        }
        else{
            log.info("Database already seeded, continuing without inserting new records...");
        }
    }

    private Person createPerson(String name, Integer born){
        return new Person(
                name,
                born
        );
    }

    private Movie createMovie(String title, String description, List<Person> directors, List<Roles> actorsAndRoles){
        Movie movie = new Movie(
                title,
                description
        );
        movie.setActorsAndRoles(actorsAndRoles);
        movie.setDirectors(directors);
        return movie;
    }
}
