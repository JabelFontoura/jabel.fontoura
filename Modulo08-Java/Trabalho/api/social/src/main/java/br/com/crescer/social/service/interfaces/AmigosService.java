package br.com.crescer.social.service.interfaces;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;

public interface AmigosService {

  Amigos save(Amigos a);

  List<Amigos> findAll();

  Amigos findById(BigDecimal id);
  
  Long countByIdUsuarioAndAceito(BigDecimal idUsuario, Character aceito);
  
  Amigos findByIdUsuarioAndIdAmigo(Usuario idUsuario, Usuario idAmigo);
  
  List<Amigos> findAllByIdUsuario(BigDecimal idUsuario);
  
  List<Amigos> findAllByIdUsuarioAndAceito(BigDecimal idUsuario, Character aceito);
  
  List<Amigos> findAllByIdAmigoAndAceito(BigDecimal idUsuario, Character aceito);
  
}
