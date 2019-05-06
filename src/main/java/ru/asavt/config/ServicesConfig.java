package ru.asavt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.asavt.dao.PersonDao;
import ru.asavt.service.PersonService;
import ru.asavt.service.PersonServiceImpl;

@Configuration
public class ServicesConfig {
    @Bean
    public PersonService personService(PersonDao dao) {
        return new PersonServiceImpl(dao);
    }
}
