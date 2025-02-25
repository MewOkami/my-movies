package me.movies.my_movies.service.imp;

import me.movies.my_movies.DTO.MoviesDTO;
import me.movies.my_movies.model.Movies;
import me.movies.my_movies.repository.MoviesRepository;
import me.movies.my_movies.repository.UserRepository;
import me.movies.my_movies.service.MoviesService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MoviesServiceImp implements MoviesService {
    private final MoviesRepository moviesRepository;

    public MoviesServiceImp(MoviesRepository moviesRepository, UserRepository userRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public MoviesDTO findById(Long id) {
        Movies movie = moviesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        return new MoviesDTO(movie);
    }

    @Override
    public MoviesDTO create(Movies moviesToCreate) {

        if (moviesRepository.existsByName(moviesToCreate.getName())) {
            throw new IllegalArgumentException("This Movie already exists");
        }

        Movies savedMovie = moviesRepository.save(moviesToCreate);
        return new MoviesDTO(savedMovie);
    }
}