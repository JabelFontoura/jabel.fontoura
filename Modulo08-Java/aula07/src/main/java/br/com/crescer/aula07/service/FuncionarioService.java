package br.com.crescer.aula07.service;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Funcionario;
import br.com.crescer.aula07.repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
  
  @Autowired
  private FuncionarioRepository repositorio;
  
  public List<Funcionario> list() {
    return (List<Funcionario>) repositorio.findAll();
  }
  
  public Funcionario findById(Long id) {
    return repositorio.findOne(id);
  }
  
  public Funcionario save(Funcionario funcionario) {
    return repositorio.save(funcionario);
  }

  public void remove(Long id) {
    repositorio.delete(id);
  }
}
