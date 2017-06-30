package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, BigDecimal>{
  
  Usuario findOneByEmail(String email);
}