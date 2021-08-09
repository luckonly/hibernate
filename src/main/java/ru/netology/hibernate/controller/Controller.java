package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.dao.Dao;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final Dao dao;

    public Controller(Dao dao) {
        this.dao = dao;
    }

    @GetMapping("/persons/by-city")
    public List<String> getPersonsByCity(@RequestParam(name = "city") String city) {
        return dao.getPersonsByCity(city);
    }

}
