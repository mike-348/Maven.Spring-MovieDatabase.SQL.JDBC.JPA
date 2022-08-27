package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person, Long id) {
        Person existingPerson = personRepository.findOne(id);
        if (existingPerson == null) {
            return null;
        }
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setSurName(person.getSurName());
        existingPerson.setMobileNumber(person.getMobileNumber());
        existingPerson.setBirthDate(person.getBirthDate());
        existingPerson.setHomeId(person.getHomeId());
        return personRepository.save(person);
    }

    public boolean removePerson(Long id) {
        personRepository.delete(id);
        return true;
    }

    public void removePeople(Iterable<Person> personList) {
        personRepository.delete(personList);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Person getByPhoneNumber(String phoneNumber) {
        Iterable<Person> personIterable = personRepository.findAll();
        for (Person person : personIterable) {
            if (person.getMobileNumber().equals(phoneNumber)) {
                return person;
            }
        }
        return null;
    }

    public Person getById(Long id) {
        return personRepository.findOne(id);
    }

    public Iterable<Person> getByFirstName(String firstName) {
        Iterable<Person> personIterable = personRepository.findAll();
        List<Person> personList = new ArrayList<>();
        for (Person person : personIterable) {
            if (person.getFirstName().equals(firstName)) {
                personList.add(person);
            }
        }
        return personList;
    }

    public Iterable<Person> getByLastName(String lastName) {
        Iterable<Person> personIterable = personRepository.findAll();
        List<Person> personList = new ArrayList<>();
        for (Person person : personIterable) {
            if (person.getSurName().equals(lastName)) {
                personList.add(person);
            }
        }
        return personList;
    }

    public Map<String, Integer> getFirstNameStats() {
        Iterable<Person> iterable = personRepository.findAll();
        Map<String, Integer> map = new HashMap<>();
        for (Person p : iterable) {
            if (map.containsKey(p.getFirstName())) {
                map.put(p.getFirstName(), map.get(p.getFirstName()) + 1);
            } else {
                map.put(p.getFirstName(), 1);
            }
        }
        return map;
    }
}
