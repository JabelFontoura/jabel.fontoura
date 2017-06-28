package br.com.crescer.aula07.repository;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
 
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
