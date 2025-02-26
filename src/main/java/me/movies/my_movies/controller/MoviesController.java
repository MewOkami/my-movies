package me.movies.my_movies.controller;

import me.movies.my_movies.DTO.MoviesDTO;
import me.movies.my_movies.model.Movies;
import me.movies.my_movies.service.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("movies")
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @PostMapping
    public ResponseEntity<MoviesDTO> create(@RequestBody MoviesDTO moviesDTO) {

        if (moviesDTO.getImageUrl() == null || moviesDTO.getImageUrl().isBlank()) {
            throw new IllegalArgumentException("The ImageUrl cannot be empty");
        }else if (moviesDTO.getName() == null || moviesDTO.getName().isBlank()) {
            throw new IllegalArgumentException("The Name cannot be empty");
        }else if (moviesDTO.getDescription() == null || moviesDTO.getDescription().isBlank()) {
            throw new IllegalArgumentException("The Description cannot be empty");
        } else if (moviesDTO.getDuration() == null) {
            throw new IllegalArgumentException("The Duration cannot be empty");
        } else if (moviesDTO.getClassification() == null) {
            throw new IllegalArgumentException("The Classification cannot be empty");
        }

        MoviesDTO createdMovie = moviesService.create(new Movies(moviesDTO));
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesDTO> findById(@PathVariable Long id) {
        MoviesDTO movie = moviesService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        moviesService.deleteMovie(id);
        return ResponseEntity.ok("Filme deletado com sucesso");
    }
}
