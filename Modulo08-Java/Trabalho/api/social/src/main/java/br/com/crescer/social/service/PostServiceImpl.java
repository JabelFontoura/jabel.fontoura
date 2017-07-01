package br.com.crescer.social.service;

 // @author Jabel
import br.com.crescer.social.model.Post;
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Post> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Post findById(BigDecimal id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}