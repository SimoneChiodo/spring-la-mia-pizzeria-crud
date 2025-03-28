package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class PizzaController {
  
  @Autowired
  private PizzaRepository repository;

  // HOME
  @GetMapping()
  public String index() {
      return "index";
  }
  
  // GET
  @GetMapping("/pizza")
  public String pizza(Model model) {
    List<Pizza> pizze = repository.findAll(); // SELECT * FROM 'pizze' => lista di oggetti di tipo Pizza

    model.addAttribute("pizze", pizze);

    return "pizza/pizza";
  }

  // SHOW
  @GetMapping("/pizza/{id}")
  public String show(@PathVariable("id") Integer id, Model model) {
    Pizza pizza = repository.findById(id).get(); // SELECT * FROM 'pizze' WHERE id = ?
    
    model.addAttribute("pizza", pizza);

    return "pizza/show";
  }
  
  // SEARCH
  @GetMapping("/pizza/search")
  public String search(@RequestParam(name = "title") String title, Model model) {
    List<Pizza> pizze = repository.findByNomeContainingIgnoreCase(title); // SELECT * FROM 'pizze' WHERE nome LIKE '%title%'
    
    model.addAttribute("pizze", pizze);

    return "pizza/pizza";
  }

  // CREATE
  @GetMapping("/pizza/create")
  public String create(Model model) {
    Pizza pizza = new Pizza(); 

    pizza.setUrlImmagine("https://picsum.photos/500/300"); // Creo un URL di default per l'immagine

    model.addAttribute("pizza", pizza);

    return "pizza/create";
  }

  // STORE
  @PostMapping("/pizza/create")
  public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "pizza/create"; // Se ci sono errori, torno alla pagina di creazione
    }

    // Se non ci sono errori, salvo la pizza nel DB
    repository.save(formPizza); // INSERT INTO 'pizze' (nome, descrizione, urlImmagine, prezzo) VALUES (?, ?, ?, ?)

    return "redirect:/pizza"; //Ritorno alla index
  }

}
