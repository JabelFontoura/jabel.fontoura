package br.com.crescer.social.service;

 // @author Jabel
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.repository.UsuarioRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

  @Autowired
  private UsuarioRepository repositorio;
  
  @Override
  public Usuario save(Usuario u) {
    return repositorio.save(u);
  }

  @Override
  public List<Usuario> findAll() {
    return (List<Usuario>) repositorio.findAll();
  }

  @Override
  public Usuario findById(BigDecimal id) {
    return repositorio.findOne(id);
  }
  
  public Usuario findByEmail(String email) {
    return repositorio.findOneByEmail(email);
  }
  
}