package br.com.crescer.social.repository;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

public interface AmigosRepository extends CrudRepository<Amigos, BigDecimal>{

}
