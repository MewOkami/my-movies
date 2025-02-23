package me.movies.my_movies;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class StartupRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    @Transactional
    public ApplicationRunner runner() {
        return args -> {
            List<Object[]> tables = entityManager.createNativeQuery("SHOW TABLES").getResultList();
            System.out.println("Tabelas no banco H2:");
            tables.forEach(row -> System.out.println(row[0]));
        };
    }
}
