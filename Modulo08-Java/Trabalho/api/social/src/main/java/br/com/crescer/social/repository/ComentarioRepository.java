package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Comentario;
import br.com.crescer.social.model.Post;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<Comentario, BigDecimal>{
  
  Long countByIdPost(Post idPost);
  
  List<Comentario> findAllByIdPost(Post idPost);

}