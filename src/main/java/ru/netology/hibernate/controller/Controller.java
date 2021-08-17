package ru.netology.hibernate.controller;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.service.PersonService;
import ru.netology.hibernate.entity.Person;

import javax.annotation.security.RolesAllowed;
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
    @Secured("ROLE_READ")
    public List<Person> getPersonsByCity(@RequestParam(name = "city") String city) {
        return personService.getByCity(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonsByAge(@RequestParam(name = "age") int age) {
        return personService.getByAgeIsLessThan(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    @PreAuthorize("hasAnyRole('ROLE_DELETE, ROLE_WRITE')")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam(name = "username") String username,
                                        @RequestParam(name = "name") String name,
                                     @RequestParam(name = "surname") String surname) {
        return personService.getPersonsByNameAndSurname(name, surname);
    }

    @GetMapping("/hello2")
    @PostAuthorize("#username == authentication.principal.username")
    public String getHelloMessage2(@RequestParam(name = "username") String username) {
            return "Hello!";
        }

}
