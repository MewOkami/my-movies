package me.movies.my_movies.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.movies.my_movies.model.Movies;
import me.movies.my_movies.model.Users;

import java.util.List;
import java.util.stream.Collectors;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MoviesDTO {
    private Long id;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Integer duration;

    @NotNull
    private Integer classification;

    private List<Long> userIds;

    public MoviesDTO() {

    }

    public MoviesDTO(Movies movies) {
        this.id = movies.getId();
        this.imageUrl = movies.getImageUrl();
        this.name = movies.getName();
        this.description = movies.getDescription();
        this.duration = movies.getDuration();
        this.classification = movies.getClassification();

        this.userIds = movies.getUsers().stream()
                .map(Users::getId)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "MoviesDTO{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", classification=" + classification +
                ", userIds=" + userIds +
                '}';
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getClassification() { return classification; }
    public void setClassification(Integer classification) { this.classification = classification; }

    public List<Long> getUserIds() { return userIds; }
    public void setUserIds(List<Long> userIds) { this.userIds = userIds; }
}