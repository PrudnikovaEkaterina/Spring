package org.example.spring.controllers;

import jakarta.validation.Valid;
import org.example.spring.dao.PersonDAO;
import org.example.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index (Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }


    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

//    Aннотация @ModelAttribute в аргументах метода делает три  вещи:
//    1. Создает новый объект класса с ключом, который мы указали (в ключ "newPerson" будет добавлен новый объект класса Person)
//    2. Назначит значения полям (set). Если данных нет, то поля будут 0 или null
//    3. Добавит новый объект в модель (model.addAttribute("newPerson", person)


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }


}
