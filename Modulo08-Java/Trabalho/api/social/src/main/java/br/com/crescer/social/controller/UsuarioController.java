package br.com.crescer.social.controller;

 // @author Jabel
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.service.UsuarioServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  
  @Autowired
  private UsuarioServiceImpl service;
  
  @GetMapping(value = "/{id}")
  public Usuario get(@PathVariable BigDecimal id) {
    return service.findById(id);
  }
  
  @GetMapping
  public List<Usuario> get() {
    return service.findAll();
  }

}