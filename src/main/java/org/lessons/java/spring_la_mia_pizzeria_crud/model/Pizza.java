package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizze")
public class Pizza {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "Il nome non può essere vuoto")
  public String nome;

  public String descrizione;

  public String urlImmagine;

  @NotNull(message = "Il prezzo non può essere null")
  @Min(value = 0, message = "Il prezzo deve essere maggiore di 0")
  public BigDecimal prezzo;

  // Costructors
  public Pizza() {
  }

  public Pizza(String nome, String descrizione, String urlImmagine, BigDecimal prezzo) {
    this.nome = nome;
    this.descrizione = descrizione;
    this.urlImmagine = urlImmagine;
    this.prezzo = prezzo;
  }


  // Getters & Setters

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return this.descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getUrlImmagine() {
    return this.urlImmagine;
  }

  public void setUrlImmagine(String urlImmagine) {
    this.urlImmagine = urlImmagine;
  }

  public BigDecimal getPrezzo() {
    return this.prezzo;
  }

  public void setPrezzo(BigDecimal prezzo) {
    this.prezzo = prezzo;
  }

}
