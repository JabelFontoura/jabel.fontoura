package br.com.crescer.social.controller;

 // @author Jabel
import br.com.crescer.social.model.Comentario;
import br.com.crescer.social.service.interfaces.ComentarioService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
  
  @Autowired
  private ComentarioService service;
  
  @GetMapping(value = "/{id}")
  public List<Comentario> findAllByIdPost(@PathVariable BigDecimal id) {
    return service.findAllByIdPost(id);
  }
  
  @PostMapping
  @ResponseBody
  public Comentario post(@RequestBody Comentario comentario) {
    return service.save(comentario);
  }
  
  @GetMapping(value = "/count/{id}")
  public Long countComentarioPorPost(@PathVariable BigDecimal id) {
    return service.countByIdPost(id);
  }
}