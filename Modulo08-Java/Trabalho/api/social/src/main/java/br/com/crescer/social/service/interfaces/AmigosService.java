package br.com.crescer.social.service.interfaces;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

public interface AmigosService {

  Amigos save(Amigos a);

  List<Amigos> findAll();

  Amigos findById(BigDecimal id);
  
}
