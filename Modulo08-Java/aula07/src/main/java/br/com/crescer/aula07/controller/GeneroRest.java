package br.com.crescer.aula07.controller;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Genero;
import br.com.crescer.aula07.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping(value = "/api/genero")
public class GeneroRest {
  
  @Autowired
  private GeneroService service;
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Genero> list() {
    return service.list();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Genero findById(@PathVariable Long id) {
    return service.findById(id);
  }
  
  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Genero save(@RequestBody Genero genero) {
    return service.save(genero);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public void delete(@PathVariable Long id) {
    service.remove(id);
  }
}
