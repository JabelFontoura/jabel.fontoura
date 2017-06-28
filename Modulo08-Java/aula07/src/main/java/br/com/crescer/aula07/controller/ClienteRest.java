package br.com.crescer.aula07.controller;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Cliente;
import br.com.crescer.aula07.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteRest {
  
  @Autowired
  private ClienteService service;
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Cliente> list() {
    return service.list();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Cliente findById(@PathVariable Long id) {
    return service.findById(id);
  }
  
  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Cliente save(@RequestBody Cliente cliente) {
    return service.save(cliente);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    service.remove(id);
  }
  
}
