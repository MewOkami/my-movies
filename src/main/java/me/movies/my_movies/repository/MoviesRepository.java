package me.movies.my_movies.repository;

import me.movies.my_movies.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    boolean existsByName(String name);
}
