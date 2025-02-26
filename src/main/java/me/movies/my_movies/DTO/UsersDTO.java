package me.movies.my_movies.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.validation.constraints.NotBlank;
import me.movies.my_movies.model.Movies;
import me.movies.my_movies.model.Users;

import java.util.List;
import java.util.stream.Collectors;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UsersDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    private String email;

    @JsonProperty("movieIds")
    private List<Long> movieIds;

    public UsersDTO() {

    }

    public UsersDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();

        this.movieIds = user.getMovies().stream()
                .map(Movies::getId)
                .collect(Collectors.toList());
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Long> getMovieIds() { return movieIds; }
    public void setMovieIds(List<Long> movieIds) { this.movieIds = movieIds; }
}