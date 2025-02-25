package me.movies.my_movies.service;

import me.movies.my_movies.DTO.MoviesDTO;
import me.movies.my_movies.model.Movies;

public interface MoviesService {

    MoviesDTO findById(Long id);
    MoviesDTO create(Movies moviesToCreate);
}
