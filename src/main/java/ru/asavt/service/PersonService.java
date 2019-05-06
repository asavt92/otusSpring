package ru.asavt.service;

import org.springframework.context.annotation.Bean;
import ru.asavt.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
