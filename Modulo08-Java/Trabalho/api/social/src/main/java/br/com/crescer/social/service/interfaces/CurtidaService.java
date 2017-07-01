package br.com.crescer.social.service.interfaces;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import java.math.BigDecimal;
import java.util.List;
 
public interface CurtidaService {
  Curtida save(Curtida c);

  List<Curtida> findAll();

  Curtida findById(BigDecimal id); 
}