package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Comentario;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, BigDecimal>{

}