package me.movies.my_movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import me.movies.my_movies.DTO.MoviesDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @Column(unique = true)
    private  String name;

    private  String description;

    private  Integer duration;

    private  Integer classification;

    @ManyToMany(mappedBy = "movies")
    private Set<Users> users = new HashSet<>();

    public Movies() {

    }

    public Movies(MoviesDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.classification = dto.getClassification();
        this.duration = dto.getDuration();
        this.imageUrl = dto.getImageUrl();
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getImageUrl() {return imageUrl;}
    public void  setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public String getName() {return name;}
    public void  setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Integer getDuration() {return duration;}
    public void  setDuration(Integer duration) {this.duration = duration;}

    public  Integer getClassification() {return classification;}
    public void setClassification(Integer classification) {this.classification = classification;}

    public Set<Users> getUsers() {
        return users != null ? users : new HashSet<>();
    }

    public void setUsers(Set<Users> users) {
        this.users = users != null ? users : new HashSet<>();
    }

    public String getTitle() {
        return null;
    }
}
