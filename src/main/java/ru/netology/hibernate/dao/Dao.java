package ru.netology.hibernate.dao;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class Dao {

    @PersistenceContext
    EntityManager entityManager;

    public Dao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> getPersonsByCity(String city) {
       Query query = entityManager.createQuery("SELECT person.name FROM Person person WHERE lower(person.city_of_living) = lower(:city)");
       query.setParameter("city", city);
       return query.getResultList();
    }

}
