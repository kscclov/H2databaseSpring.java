package com.example.H2database.repositories;

import com.example.H2database.models.vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface vacancyRepository extends JpaRepository<vacancy, Long> {
    List<vacancy> findByTitle(String title);
    List<vacancy> findByJobTitleAndCity(String jobTitle, String city);

}
