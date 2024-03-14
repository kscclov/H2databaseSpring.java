package com.example.H2database.services;

import com.example.H2database.repositories.vacancyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.H2database.models.vacancy;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class vacancyService {
    private final vacancyRepository vacancyRepository;

    public List<vacancy> listVacancies(String title) {
        if (title != null) vacancyRepository.findByTitle(title);
        return vacancyRepository.findAll();
    }

    public void saveVacancy(vacancy vacancy) {
        log.info("saving new {}", vacancy);
        vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }

    public vacancy getVacancyId(Long id) {
        return vacancyRepository.findById(id).orElse(null);
    }
}
