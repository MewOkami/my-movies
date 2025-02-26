package me.movies.my_movies.service;

import me.movies.my_movies.DTO.UsersDTO;

public interface UserService {

    UsersDTO findById(Long id);
    UsersDTO create(UsersDTO usersDTO);
    void deleteUsers(Long id);
}
