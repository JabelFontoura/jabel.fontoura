package br.com.crescer.social.controller;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import br.com.crescer.social.service.interfaces.CurtidaService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/curtida")
public class CurtidaController {

  @Autowired
  private CurtidaService service;
  
  @PostMapping
  @ResponseBody
  public Curtida post(@RequestBody Curtida curtida) {
    return service.save(curtida);
  }
  
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable BigDecimal id) {
    service.delete(id);
  }
  
  @GetMapping(value = "/count/{id}")
  public Long countByPost(@PathVariable BigDecimal id) {
    return service.countByIdPost(id);
  }
  
  @GetMapping(value = "/post/{id}")
  public List<Curtida> getByPost(@PathVariable BigDecimal id) {
    return service.findByIdPost(id);
  }
}