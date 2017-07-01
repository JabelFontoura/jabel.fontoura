package br.com.crescer.social.service;

 // @author jabel.fontoura
import br.com.crescer.social.service.interfaces.AmigosService;
import br.com.crescer.social.model.Amigos;
import br.com.crescer.social.model.Usuario;
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
    return (List<Amigos>) repositorio.findAll();
  }

  @Override
  public Amigos findById(BigDecimal id) {
    return repositorio.findOne(id);
  }
  
  @Override
  public Long countByIdUsuarioAndAceito(BigDecimal idUsuario, Character aceito) {
    final Usuario usuario = new Usuario();
    usuario.setId(idUsuario);
    
    return repositorio.countByIdUsuarioAndAceito(usuario, aceito);
  }
}
