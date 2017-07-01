package br.com.crescer.social.service.interfaces;

 // @author jabel.fontoura
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
 
public interface UsuarioService {
  
  Usuario save(Usuario u);

  List<Usuario> findAll();

  Usuario findById(BigDecimal id);
  
  Usuario findByEmail(String email);
}