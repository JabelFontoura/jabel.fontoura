package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Post;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, BigDecimal>{

}