package me.movies.my_movies.service;

import jakarta.transaction.Transactional;
import me.movies.my_movies.DTO.UsersDTO;
import me.movies.my_movies.model.Users;

public interface UserService {

    UsersDTO findById(Long id);

    UsersDTO create(UsersDTO usersDTO);
}
