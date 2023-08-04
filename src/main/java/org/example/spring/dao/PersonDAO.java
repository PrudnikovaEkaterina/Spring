package org.example.spring.dao;

import org.example.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", "Tomy", "tom@mail.ru", 18));
        people.add(new Person(++PEOPLE_COUNT, "Bob", "Boby", "bob@mail.ru", 25));
        people.add(new Person(++PEOPLE_COUNT, "Mike", "Mikey", "mike@mail.ru", 54));
        people.add(new Person(++PEOPLE_COUNT, "Katy", "Katyy", "katy@mail.ru", 34));
    }

    public List<Person> index() {
        return people;
    }
    public Person show (int id) {
        return people.stream().filter(el->el.getId()==id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update (int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setSurname(person.getSurname());
        personToBeUpdated.setEmail(person.getEmail());
        personToBeUpdated.setAge(person.getAge());
    }

    public void delete (int id) {
       people.removeIf(el->el.getId()==id);
    }
}
