package me.movies.my_movies.model;

import jakarta.persistence.*;
import me.movies.my_movies.DTO.UsersDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    @Column(unique = true)
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movies> movies = new HashSet<>();

    public Users() {}

    public Users(UsersDTO usersDTO) {

    }

    public Users(UsersDTO usersDTO, List<Movies> moviesList) {
        this.id = usersDTO.getId();
        this.name = usersDTO.getName();
        this.nickname = usersDTO.getNickname();
        this.email = usersDTO.getEmail();

        this.movies = new HashSet<>(moviesList);
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getNickname() {return nickname;}
    public void setNickname(String nickname) {this.nickname = nickname;}

    public String getEmail() {return  email;}
    public void setEmail(String email) {this.email = email;}

    public Set<Movies> getMovies() { return movies; }
    public void setMovies(Set<Movies> movies) { this.movies = movies; }
}
