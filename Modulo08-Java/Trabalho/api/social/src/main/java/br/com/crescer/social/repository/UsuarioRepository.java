package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, BigDecimal>{
  
  Usuario findOneByEmail(String email);
  
  List<Usuario> findByIdNotIn(Collection<BigDecimal> ids);
}