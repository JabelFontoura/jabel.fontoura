package br.com.crescer.aula07.service;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Video;
import br.com.crescer.aula07.repository.VideoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
  
  @Autowired
  private VideoRepository repositorio;
  
  public List<Video> list() {
    return (List<Video>) repositorio.findAll();
  }
  
  public Video findById(Long id) {
    return repositorio.findOne(id);
  }
  
  public Video save(Video video) {
    return repositorio.save(video);
  }

  public void remove(Long id) {
    repositorio.delete(id);
  }
}
