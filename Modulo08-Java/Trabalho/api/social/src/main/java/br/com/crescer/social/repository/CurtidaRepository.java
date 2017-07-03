package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
 
public interface CurtidaRepository extends CrudRepository<Curtida, BigDecimal>{

  Long countByIdPost(Post idPost);
  
  List<Curtida> findByIdPost(Post idPost);
  
  List<Curtida> findByIdUsuario(Usuario idUsuario);
}