package com.example.H2database.repositories;

import com.example.H2database.models.subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface subscriberRepository extends JpaRepository<subscriber, Long> {
    List<subscriber> findByTitle(String title);

}
