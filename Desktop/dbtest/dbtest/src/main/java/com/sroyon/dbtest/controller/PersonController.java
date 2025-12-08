package com.sroyon.dbtest.controller;

import com.sroyon.dbtest.model.Person;
import com.sroyon.dbtest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @Autowired
    PersonService personService;
    @GetMapping("/person")
    public List<Person> getPersons() {

        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/person/add")
    public void addPerson(@RequestBody Person person) {
            personService.addPerson(person);
    }

    @PostMapping("/person/del/{id}")
    public void delById(@PathVariable int id) {
        personService.deletePersonById(id);
    }
}
