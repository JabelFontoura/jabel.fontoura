package br.com.crescer.social.controller;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.service.interfaces.AmigosService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amigos")
public class AmigosController {
  
  @Autowired
  private AmigosService service;
  
  @GetMapping(value = "/{id}")
  public Amigos get(@PathVariable BigDecimal id) {
    return service.findById(id);
  }
  
  @PostMapping
  @ResponseBody
  public Amigos post(@RequestBody Amigos amigos) {
    return service.save(amigos);
  }
}
