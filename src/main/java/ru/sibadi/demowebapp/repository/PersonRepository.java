package ru.sibadi.demowebapp.repository;

import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Person;

import java.util.List;

@Repository
public class PersonRepository {

    private final List<Person> persons = List.of(
            new Person(100, "Рик Санчес", 10_000),
            new Person(200, "Морти Смит", 20_000),
            new Person(300, "Саммер Смит", 30_000),
            new Person(400, "Мистер Жопосранчик", 25_000)
    );

    public List<Person> findAllPersons() {
        return persons;
    }

    public Person findPersonById(int id) {
        Person foundPerson = null;
        for (Person p : persons) {
            if (p.getId() == id) {
                foundPerson = p;
            }
        }
        return foundPerson;
    }
}
