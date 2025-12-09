package com.sroyon.dbtest.service;

import com.sroyon.dbtest.PersonNotFoundException;
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
        return repo.findById(id).orElseThrow(()-> new PersonNotFoundException("Person not found with id "+id));

    }

    public void addPerson(Person person){
        repo.save(person);
    }

    public void deletePersonById(int id){
        if(!repo.existsById(id)){
            throw new PersonNotFoundException("Person does not exist with id "+id);
        }
        repo.deleteById(id);
    }
}

