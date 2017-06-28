package br.com.crescer.aula07.repository;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Cliente;
import org.springframework.data.repository.CrudRepository;

 
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
