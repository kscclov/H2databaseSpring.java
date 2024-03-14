package com.example.H2database.controllers;

import com.example.H2database.models.vacancy;
import com.example.H2database.services.vacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class vacancyController {
    private final vacancyService vacancyService;

    @GetMapping("/")
    public String vacancies(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("vacancies", vacancyService.listVacancies(title));
        return "vacancies";
    }

    @PostMapping("/")
    public String createVacancy(vacancy vacancy) {
        vacancyService.saveVacancy(vacancy);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
        return "redirect:/";
    }
}
