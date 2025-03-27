package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class PizzaController {
  

  
  @GetMapping()
  public String index() {
      return "index";
  }
  
  @GetMapping("/pizza")
  public String pizza() {
      return "pizza/pizza";
  }
  

}
