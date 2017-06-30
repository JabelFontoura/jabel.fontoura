package br.com.crescer.social.service;

 // @author jabel.fontoura
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.repository.AmigosRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmigosServiceImpl implements AmigosService {

  @Autowired
  private AmigosRepository repositorio;
  
  @Override
  public Amigos save(Amigos a) {
    return repositorio.save(a);
  }

  @Override
  public List<Amigos> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Amigos findById(BigDecimal id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


}
