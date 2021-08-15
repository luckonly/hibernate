package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.service.PersonService;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final PersonService personService;

    public Controller(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello!";
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(name = "city") String city) {
        return personService.getByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam(name = "age") int age) {
        return personService.getByAgeIsLessThan(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam(name = "name") String name,
                                     @RequestParam(name = "surname") String surname) {
        return personService.getPersonsByNameAndSurname(name, surname);
    }

}
