package br.com.crescer.social.service.interfaces;

 // @author Jabel
import br.com.crescer.social.model.Comentario;
import java.math.BigDecimal;
import java.util.List;

public interface ComentarioService {
  
  Comentario save(Comentario a);

  List<Comentario> findAll();

  Comentario findById(BigDecimal id);
}