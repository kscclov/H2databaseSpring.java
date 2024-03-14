package com.example.H2database.services;

import com.example.H2database.models.subscriber;
import com.example.H2database.models.vacancy;
import com.example.H2database.repositories.vacancyRepository;
import com.example.H2database.repositories.subscriberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailRoute extends RouteBuilder {
    @Autowired
    private final vacancyRepository vacancyRepository;
    @Autowired
    private final subscriberRepository subscriberRepository;

    @Override
    public void configure() throws Exception {
        from("quartz2://myScheduler?cron=0+0+0+1/1+*+?")
                .process(exchange -> {
                    List<subscriber> subscribers = subscriberRepository.findAll();
                    for (subscriber subscriber : subscribers) {
                        List<vacancy> vacancies = vacancyRepository.findByJobTitleAndCity(subscriber.getJobTitlesub(), subscriber.getCity());
                        StringBuilder message = new StringBuilder();
                        message.append("Здравствуйте, ").append(subscriber.getName()).append(",\n\n");
                        for (vacancy vacancy : vacancies) {
                            message.append("Информируем вас о новой вакансии на должность: ").append(vacancy.getJobTitle()).append("\n");
                            message.append("Наименование: ").append(vacancy.getTitle()).append("\n");
                            message.append("Описание: ").append(vacancy.getDescription()).append("\n");
                            message.append("Уровень зарплаты: ").append(vacancy.getSalary()).append("\n");
                            message.append("Требуемый опыт работы: ").append(vacancy.getExperience()).append("\n\n");
                            message.append("С уважением, \n\n Цифровое будущее \n\n");
                        }
                        message.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                        exchange.getMessage().setBody(message.toString());
                        exchange.getMessage().setHeader("subject", "Цифровое будущее");
                        exchange.getMessage().setHeader("from", "numfuture@mail.org");
                        exchange.getMessage().setHeader("to", subscriber.getEmail());
                    }
                })
                .to("smtps:smtp.example.com?username=yourUsername&password=yourPassword&debugMode=true");
    }
}
