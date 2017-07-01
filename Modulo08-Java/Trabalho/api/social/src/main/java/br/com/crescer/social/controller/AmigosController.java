package br.com.crescer.social.controller;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.service.interfaces.AmigosService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  
  @GetMapping
  public List<Amigos> get() {
    return service.findAll();
  }
  
  @GetMapping(value = "/aceitos")
  public Long countAceitos(@RequestParam BigDecimal idUsuario, @RequestParam Character aceito) {
    return service.countByIdUsuarioAndAceito(idUsuario, aceito);
  }
  
  @PostMapping
  @ResponseBody
  public Amigos post(@RequestBody Amigos amigos) {
    return service.save(amigos);
  }
}
