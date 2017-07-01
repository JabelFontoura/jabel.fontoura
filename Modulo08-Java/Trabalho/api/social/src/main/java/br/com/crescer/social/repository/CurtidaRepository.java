package br.com.crescer.social.repository;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;
 
public interface CurtidaRepository extends CrudRepository<Curtida, BigDecimal>{

}