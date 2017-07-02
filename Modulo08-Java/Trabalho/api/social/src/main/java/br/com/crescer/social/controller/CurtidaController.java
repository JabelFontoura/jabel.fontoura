package br.com.crescer.social.controller;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
@RequestMapping("/curtida")
public class CurtidaController {

  @Autowired
  private CurtidaService service;
  
  @GetMapping(value = "/{id}")
  public Curtida getByPost(@PathVariable BigDecimal id) {
    return null;
  }
  
}