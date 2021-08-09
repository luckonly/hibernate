package ru.netology.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.city = :city")
    List<Person> getPersonByCity(@Param("city") String city);
    @Query("select p from Person p where p.age < :age")
    List<Person> getPersonByAgeIsLessThan(@Param("age") int age);
    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> getByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
