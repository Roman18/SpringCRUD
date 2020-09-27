package com.example.controllers;


import com.example.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
private PersonDAO personDAO;

    @GetMapping()
    public String index(Model model){
// Получить всех людей из DAO
        model.addAttribute("people",personDAO.getAllPeople());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
//Получить 1 человека по id из DAO
        model.addAttribute("person",personDAO.getPerson(id));
return "people/show";
    }

}
