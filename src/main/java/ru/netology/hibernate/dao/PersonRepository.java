package ru.netology.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getByCity(String city);
    List<Person> getByAgeIsLessThan(int age);
    Optional<Person> getByNameAndSurname(String name, String surname);

}
