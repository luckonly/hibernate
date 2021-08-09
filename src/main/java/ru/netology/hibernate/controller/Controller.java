package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.dao.Dao;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final Dao dao;

    public Controller(Dao dao) {
        this.dao = dao;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(name = "city") String city) {
        return dao.getByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam(name = "age") int age) {
        return dao.getByAgeIsLessThan(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam(name = "name") String name,
                                     @RequestParam(name = "surname") String surname) {
        return dao.getPersonsByNameAndSurname(name, surname);
    }

}
