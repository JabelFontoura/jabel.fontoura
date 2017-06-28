package br.com.crescer.aula07.controller;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Locacao;
import br.com.crescer.aula07.service.LocacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/locacao")
public class LocacaoRest {

  @Autowired
  private LocacaoService service;
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Locacao> list() {
    return service.list();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Locacao findById(@PathVariable Long id) {
    return service.findById(id);
  }
  
  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Locacao save(@RequestBody Locacao locacao) {
    return service.save(locacao);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    service.remove(id);
  }
}
