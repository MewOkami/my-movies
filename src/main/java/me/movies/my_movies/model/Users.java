package me.movies.my_movies.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Movies> movies;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNickname() {return nickname;}

    public void setNickname(String nickname) {this.nickname = nickname;}

    public String getEmail() {return  email;}

    public void setEmail(String email) {this.email = email;}

    public List<Movies> getMovies() {return movies;}

    public void setMovies(List<Movies> movies) {this.movies = movies;}
}
