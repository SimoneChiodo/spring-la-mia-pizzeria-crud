package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {
  
  @Autowired
  private PizzaRepository repository;

  @GetMapping()
  public String index() {
      return "index";
  }
  
  @GetMapping("/pizza")
  public String pizza(Model model) {
    List<Pizza> pizze = repository.findAll(); // SELECT * FROM 'pizze' => lista di oggetti di tipo Pizza

    model.addAttribute("pizze", pizze);

    return "pizza/pizza";
  }
  

}
