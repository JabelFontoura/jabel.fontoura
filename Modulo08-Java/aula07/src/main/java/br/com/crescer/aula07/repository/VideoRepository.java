package br.com.crescer.aula07.repository;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Video;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
 
public interface VideoRepository extends CrudRepository<Video, Serializable>{

}
