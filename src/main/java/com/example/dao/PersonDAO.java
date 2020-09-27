package com.example.dao;

import com.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_COUNT;
    private List<Person> people;
    public PersonDAO(){

        people=new ArrayList<>();
        people.add(new Person(++PERSON_COUNT,"Ivan"));
        people.add(new Person(++PERSON_COUNT,"Koly"));
        people.add(new Person(++PERSON_COUNT,"Igor"));
        people.add(new Person(++PERSON_COUNT,"Danil"));

    }
    public List<Person> getAllPeople(){

        return people;
    }
    public Person getPerson(int id){
        return people.stream().
                filter(person->person.getId()==id).
                findAny().orElse(null);
    }
}
