package ru.netology.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class Dao {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getByCity(String city) {
        return personRepository.getByCity(city);
    }

    public List<Person> getByAgeIsLessThan(int age) {
        return personRepository.getByAgeIsLessThan(age);
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.getByNameAndSurname(name, surname);
    }

}
