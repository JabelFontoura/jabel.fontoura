package br.com.crescer.social.service.interfaces;

 // @author Jabel
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 
public interface PostService {
  
  Post save(Post p);

  List<Post> findAll();

  Post findById(BigDecimal id);

  List<Post> findAllByIdUsuario(BigDecimal id);
  
  Page<Post> findByIdUsuarioInOrderByIdDesc(List<Usuario> usuarios, Pageable pageable);
}