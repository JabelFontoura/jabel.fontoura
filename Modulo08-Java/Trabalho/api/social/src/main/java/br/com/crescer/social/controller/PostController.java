package br.com.crescer.social.controller;

 // @author Jabel
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.service.interfaces.AmigosService;
import br.com.crescer.social.service.interfaces.PostService;
import br.com.crescer.social.service.interfaces.UsuarioService;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostService postService;
  @Autowired
  private UsuarioService usuarioService;
  @Autowired
  private AmigosService amigosSerivce;
  
  @GetMapping
  public List<Post> get() {
    return postService.findAll();
  }
  
//  @GetMapping(value = "/lista/{id}")
//  public List<Post> getPostByIdUsuario(@PathVariable BigDecimal id) {
//    return postService.findAllByIdUsuario(id);
//  }
  
  @GetMapping(value = "/lista/{id}")
  public List<Post> getPostByIdUsuario(@PathVariable BigDecimal id) {
    List<Amigos> amigos = amigosSerivce.findAllByIdUsuario(id);
    List<Usuario> usuarios = new ArrayList<>();
    
    usuarios.add(usuarioService.findById(id));
    
    amigos.forEach((a) -> {
      usuarios.add(a.getIdAmigo());
    });
    
    
    return postService.findByIdUsuarioInOrderByIdDesc(usuarios);
  }
  
  @PostMapping
  @ResponseBody
  public Post post(@RequestBody Post post) {
    return postService.save(post);
  }
}