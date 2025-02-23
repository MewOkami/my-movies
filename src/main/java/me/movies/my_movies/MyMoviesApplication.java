package me.movies.my_movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "me.movies.my_movies.model")
public class MyMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMoviesApplication.class, args);
	}

}

