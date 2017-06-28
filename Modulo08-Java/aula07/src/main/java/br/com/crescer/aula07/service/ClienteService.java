package br.com.crescer.aula07.service;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Cliente;
import br.com.crescer.aula07.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository repositorio;
  
  public List<Cliente> list() {
    return (List<Cliente>) repositorio.findAll();
  }
  
  public Cliente findById(Long id) {
    return repositorio.findOne(id);
  }
  
  public Cliente save(Cliente cliente) {
    return repositorio.save(cliente);
  }

  public void remove(Long id) {
    repositorio.delete(id);
  }
}
