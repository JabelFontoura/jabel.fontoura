package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Post;
import br.com.crescer.social.model.Usuario;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, BigDecimal>{

  List<Post> findAllByIdUsuario(Usuario IdUsuario);
  
  Page<Post> findByIdUsuarioInOrderByIdDesc(List<Usuario> usuarios, Pageable pageable);

}