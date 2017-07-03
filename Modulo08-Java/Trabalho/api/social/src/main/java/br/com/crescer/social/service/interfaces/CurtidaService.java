package br.com.crescer.social.service.interfaces;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import br.com.crescer.social.model.Post;
import java.math.BigDecimal;
import java.util.List;
 
public interface CurtidaService {
  Curtida save(Curtida c);
  
  void delete(BigDecimal id);

  List<Curtida> findAll();

  Curtida findById(BigDecimal id); 
  
  Long countByIdPost(BigDecimal idPost);
  
  List<Curtida> findByIdUsuario(BigDecimal idUsuario);
  
  List<Curtida> findByIdPost(BigDecimal idPost);
}