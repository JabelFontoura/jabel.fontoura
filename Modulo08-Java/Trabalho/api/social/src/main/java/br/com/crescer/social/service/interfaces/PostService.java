package br.com.crescer.social.service.interfaces;

 // @author Jabel
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
 
public interface PostService {
  
  Post save(Post p);

  List<Post> findAll();

  Post findById(BigDecimal id);

  List<Post> findAllByIdUsuario(BigDecimal id);
  
  List<Post> findByIdUsuarioInOrderByIdDesc(List<Usuario> usuarios);
}