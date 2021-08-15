package ru.netology.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.dao.PersonRepository;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getByCity(String city) {
        return personRepository.getPersonByCity(city);
    }

    public List<Person> getByAgeIsLessThan(int age) {
        return personRepository.getPersonByAgeIsLessThan(age);
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.getByNameAndSurname(name, surname);
    }

}
