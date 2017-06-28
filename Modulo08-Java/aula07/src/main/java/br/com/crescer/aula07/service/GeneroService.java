package br.com.crescer.aula07.service;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Genero;
import br.com.crescer.aula07.repository.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
  
  @Autowired
  private GeneroRepository repositorio;
  
  public List<Genero> list() {
    return (List<Genero>) repositorio.findAll();
  }
  
  public Genero findById(Long id) {
    return repositorio.findOne(id);
  }
  
  public Genero save(Genero genero) {
    return repositorio.save(genero);
  }

  public void remove(Long id) {
    repositorio.delete(id);
  }
}
