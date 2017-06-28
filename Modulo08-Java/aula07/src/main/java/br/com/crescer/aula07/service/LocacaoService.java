package br.com.crescer.aula07.service;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Locacao;
import br.com.crescer.aula07.repository.LocacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class LocacaoService {

  @Autowired
  private LocacaoRepository repositorio;
  
  public List<Locacao> list() {
    return (List<Locacao>) repositorio.findAll();
  }
  
  public Locacao findById(Long id) {
    return repositorio.findOne(id);
  }
  
  public Locacao save(Locacao locacao) {
    return repositorio.save(locacao);
  }

  public void remove(Long id) {
    repositorio.delete(id);
  }
}
