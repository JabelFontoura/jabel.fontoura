package br.com.crescer.social.service;

 // @author Jabel
import br.com.crescer.social.model.Curtida;
import br.com.crescer.social.repository.CurtidaRepository;
import br.com.crescer.social.service.interfaces.CurtidaService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CurtidaServiceImpl implements CurtidaService{
  
  @Autowired
  private CurtidaRepository repositorio;

  @Override
  public Curtida save(Curtida c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Curtida> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Curtida findById(BigDecimal id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}