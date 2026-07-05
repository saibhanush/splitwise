package com.scaler.splitwise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.List;

// Your IDE will likely need to auto-import your User and UserRepository here

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Bean
    CommandLineRunner seedDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                // Adjust .setName() or constructor if your User class uses different methods
                User alice = new User();
                alice.setName("Alice"); 
                
                User bob = new User();
                bob.setName("Bob");

                userRepository.saveAll(List.of(alice, bob));
                System.out.println("Live Demo Data Seeded Successfully!");
            }
        };
    }
}