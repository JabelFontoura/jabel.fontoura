package br.com.crescer.social.controller;

// @author Jabel
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.service.interfaces.UsuarioService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService service;

  @GetMapping(value = "/logged")
  public Map<String, Object> getUserDetails(Authentication authentication) {
    final HashMap<String, Object> hashMap = new HashMap<>();
    
    Usuario u = Optional.ofNullable(authentication)
            .map(Authentication::getPrincipal)
            .map(User.class::cast)
            .map(User::getUsername)
            .map(service::findByEmail)
            .orElse(null);
    
    hashMap.put("dados", u);
    
    return hashMap;

  }

  @GetMapping(value = "/{id}")
  public Usuario get(@PathVariable BigDecimal id) {
    return service.findById(id);
  }

  @GetMapping
  public List<Usuario> get() {
    return service.findAll();
  }

  @PostMapping
  @ResponseBody
  public Usuario post(@RequestBody Usuario usuario) {
    return service.save(usuario);
  }

}
