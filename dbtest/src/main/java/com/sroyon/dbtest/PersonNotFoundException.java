package com.sroyon.dbtest;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message){
        super(message);
    }
}
