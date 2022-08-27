package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    // @TODO POST /people -- create a person
    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.addPerson(person));
    }

    // @TODO PUT /people/{id} -- update person with id. 404 error if that person doesn't exist yet
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        return ResponseEntity.ok(personService.updatePerson(person, id));
    }

    // @TODO GET /people/{id} -- get the person with the specified ID
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    // @TODO DELETE /people/{id} -- delete the person with the specified ID
    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.removePerson(id));
    }

    // @TODO GET /people -- get all people
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getAllPeople() {
        return ResponseEntity.ok(personService.findAll());
    }

    // @TODO GET /people/reverselookup/{mobileNumber} -- find all people with the specified mobile number
    @GetMapping("/people/reverselookup/{mobileNumber}")
    public ResponseEntity<Person> getAllPeopleByMobileNumber(@PathVariable String mobileNumber) {
        return ResponseEntity.ok(personService.getByPhoneNumber(mobileNumber));
    }

    // @TODO /people/surname/{lastName} -- Find all people with a particular last name
    @GetMapping("/people/surname/{lastName}")
    public ResponseEntity<Iterable<Person>> getAllPeopleByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(personService.getByLastName(lastName));
    }

    // @TODO /people/firstname/{firstName} -- Find all people with a particular first name
    @GetMapping("/people/firstname/{firstName}")
    public ResponseEntity<Iterable<Person>> getAllPeopleByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(personService.getByFirstName(firstName));
    }

    // @TODO /people/firstname/stats -- Get the report of first name frequencies
    @GetMapping("/people/firstname/stats")
    public ResponseEntity<Map<String, Integer>> getFirstNameStats() {
        return ResponseEntity.ok(personService.getFirstNameStats());
    }

}