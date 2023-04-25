package com.szalai.demograph.controller;

import com.szalai.demograph.controller.request.MovieRequest;
import com.szalai.demograph.model.Movie;
import com.szalai.demograph.repository.MovieRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DemoGraphController {

    private final MovieRepository movieRepository;

    public DemoGraphController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{title}")
    public Movie getOneMovie(@PathVariable String title){
        return movieRepository.findByTitle(title);
    }

    @PostMapping("/movies")
    public Movie addOneMovie(@RequestBody MovieRequest request){
        return movieRepository.save(new Movie(request.title(), request.description()));
    }

    @DeleteMapping("/movies/{title}")
    public void deleteOneMovie(@PathVariable String title){
        Movie movie = movieRepository.findByTitle(title);
        movieRepository.delete(movie);
    }
}
