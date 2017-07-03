package br.com.crescer.social.service;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.repository.CurtidaRepository;
import br.com.crescer.social.service.interfaces.CurtidaService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CurtidaServiceImpl implements CurtidaService{
  
  @Autowired
  private CurtidaRepository repositorio;

  @Override
  public Curtida save(Curtida c) {
    return repositorio.save(c);
  }
  
  @Override
  public void delete(BigDecimal id) {
    repositorio.delete(id);
  }
  
  @Override
  public Long countByIdPost(BigDecimal idPost) {
    Post post = new Post();
    post.setId(idPost);
    
    return repositorio.countByIdPost(post);
  }

  @Override
  public List<Curtida> findByIdUsuario(BigDecimal idUsuario) {
    Usuario usuario = new Usuario();
    usuario.setId(idUsuario);
    
    return repositorio.findByIdUsuario(usuario);
  }
  
  @Override
  public List<Curtida> findByIdPost(BigDecimal idPost) {
    Post post = new Post();
    post.setId(idPost);
    
    return repositorio.findByIdPost(post);
  }
  
  @Override
  public List<Curtida> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Curtida findById(BigDecimal id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}