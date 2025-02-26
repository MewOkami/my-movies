package me.movies.my_movies.service.imp;

import jakarta.transaction.Transactional;
import me.movies.my_movies.DTO.UsersDTO;
import me.movies.my_movies.model.Movies;
import me.movies.my_movies.model.Users;
import me.movies.my_movies.repository.MoviesRepository;
import me.movies.my_movies.repository.UserRepository;
import me.movies.my_movies.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final MoviesRepository moviesRepository;

    public UserServiceImp(UserRepository userRepository, MoviesRepository moviesRepository) {
        this.userRepository = userRepository;
        this.moviesRepository = moviesRepository;
    }

    @Override
    public UsersDTO findById(Long id) {
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UsersDTO(users);
    }

    @Override
    @Transactional
    public UsersDTO create(UsersDTO usersDTO) {

        if (userRepository.existsByEmail(usersDTO.getEmail())) {
            throw new IllegalArgumentException("This User already exists");
        }

        List<Movies> movies = moviesRepository.findAllById(usersDTO.getMovieIds());

        Users usersToCreate = new Users(usersDTO, movies);
        Users savedUser = userRepository.save(usersToCreate);

        return new UsersDTO(savedUser);
    }

    @Override
    public void deleteUsers(Long id) {
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        for (Movies movies : users.getMovies()) {
            movies.getUsers().remove(users);
        }

        users.getMovies().clear();
        userRepository.save(users);

        userRepository.deleteById(id);
    }
}
