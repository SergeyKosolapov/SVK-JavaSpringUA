package com.cbs.springcourse.rest.controllers;

import com.cbs.springcourse.rest.models.Person;
import com.cbs.springcourse.rest.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody над кожним методом
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертує ці об'єкти у JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id); // Jackson конвертує у JSON
    }
}
