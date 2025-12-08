package com.sroyon.dbtest.service;

import com.sroyon.dbtest.model.Person;
import com.sroyon.dbtest.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class PersonService {

    @Autowired
    private PersonRepo repo;
    public List<Person> getAllPersons() {
        return repo.findAll();
    }

    public Person getPersonById(int id){
        return repo.findById(id).get();
    }

    public void addPerson(Person person){
        repo.save(person);
    }

    public void deletePersonById(int id){
        repo.deleteById(id);
    }
}

