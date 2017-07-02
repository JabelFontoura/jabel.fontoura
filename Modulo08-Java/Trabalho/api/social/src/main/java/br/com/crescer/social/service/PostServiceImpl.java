package br.com.crescer.social.service;

 // @author Jabel
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import br.com.crescer.social.repository.PostRepository;
import br.com.crescer.social.service.interfaces.PostService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
  
  @Autowired
  private PostRepository repositorio;

  @Override
  public Post save(Post p) {
    return repositorio.save(p);
  }

  @Override
  public List<Post> findAll() {
    return (List<Post>) repositorio.findAll();
  }

  @Override
  public Post findById(BigDecimal id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Post> findAllByIdUsuario(BigDecimal idUsuario) {
    Usuario u = new Usuario();
    u.setId(idUsuario);
    
    return repositorio.findAllByIdUsuario(u);
  }

  @Override
  public List<Post> findByIdUsuarioInOrderByIdDesc(List<Usuario> usuarios) {
    return repositorio.findByIdUsuarioInOrderByIdDesc(usuarios);
  }
}