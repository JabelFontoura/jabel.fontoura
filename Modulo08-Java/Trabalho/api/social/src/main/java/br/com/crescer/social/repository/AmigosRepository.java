package br.com.crescer.social.repository;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AmigosRepository extends CrudRepository<Amigos, BigDecimal>{
  
  Long countByIdAmigoAndAceito(Usuario idUsuario, Character aceito);
  
  Amigos findByIdUsuarioAndIdAmigo(Usuario idUsuario, Usuario idAmigo);
  
  List<Amigos> findAllByIdUsuario(Usuario idUsuario);
  
  List<Amigos> findByIdAmigoAndAceito(Usuario idUsuario, Character aceito);
  
  List<Amigos> findByIdUsuarioAndAceito(Usuario idUsuario, Character aceito);
  
}
