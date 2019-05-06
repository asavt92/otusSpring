package ru.asavt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.asavt.dao.PersonDao;
import ru.asavt.dao.PersonDaoSimple;
@Configuration
public class DaoConfig {
    @Bean
    public PersonDao personDao() {
        return new PersonDaoSimple();
    }
}
