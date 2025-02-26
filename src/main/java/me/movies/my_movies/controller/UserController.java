package me.movies.my_movies.controller;

import me.movies.my_movies.DTO.UsersDTO;
import me.movies.my_movies.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UsersDTO> create(@RequestBody UsersDTO usersDTO) {
        if (usersDTO.getName() == null || usersDTO.getName().isBlank()){
            throw new IllegalArgumentException("The Name cannot be empty");
        } else if (usersDTO.getNickname() == null || usersDTO.getNickname().isBlank()) {
            throw new IllegalArgumentException("The Nickname cannot be empty");
        } else if (usersDTO.getEmail() == null || usersDTO.getEmail().isBlank()) {
            throw new IllegalArgumentException("The Email cannot be empty");
        }

        UsersDTO createdUsers = userService.create(usersDTO);
        return ResponseEntity.ok().body(createdUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> findById(@PathVariable Long id) {
        UsersDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
        userService.deleteUsers(id);
        return ResponseEntity.ok("User deletado com sucesso");
    }
}
