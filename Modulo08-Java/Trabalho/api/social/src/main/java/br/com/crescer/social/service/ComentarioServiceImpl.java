package br.com.crescer.social.service;

 // @author Jabel
import br.com.crescer.social.service.interfaces.ComentarioService;
import br.com.crescer.social.model.Comentario;
import br.com.crescer.social.model.Post;
import br.com.crescer.social.repository.ComentarioRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements ComentarioService {

  @Autowired
  private ComentarioRepository repositorio;

  @Override
  public Comentario save(Comentario a) {
    return repositorio.save(a);
  }

  @Override
  public List<Comentario> findAll() {
    return (List<Comentario>) repositorio.findAll();
  }

  @Override
  public Comentario findById(BigDecimal id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Long countByIdPost(BigDecimal idPost) {
    final Post post = new Post();
    post.setId(idPost);
    
    return repositorio.countByIdPost(post);
  }

  @Override
  public List<Comentario> findAllByIdPost(BigDecimal idPost) {
    final Post post = new Post();
    post.setId(idPost);
    
    return repositorio.findAllByIdPost(post);
  }
}