package me.movies.my_movies.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

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

    private  BigDecimal duration;

    private  BigDecimal classification;


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getImageUrl() {return imageUrl;}

    public void  setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public String getName() {return name;}

    public void  setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public BigDecimal getDuration() {return duration;}

    public void  setDuration(BigDecimal duration) {this.duration = duration;}

    public  BigDecimal getClassification() {return classification;}

    public void setClassification(BigDecimal classification) {this.classification = classification;}
}
