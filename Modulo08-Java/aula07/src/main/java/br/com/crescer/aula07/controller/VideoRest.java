package br.com.crescer.aula07.controller;

 // @author jabel.fontoura
import br.com.crescer.aula07.model.Video;
import br.com.crescer.aula07.service.VideoService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/video")
public class VideoRest {
  
  public VideoService service;
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Video> list() {
    return service.list();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Video findById(@PathVariable Long id) {
    return service.findById(id);
  }
  
  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Video save(@RequestBody Video video) {
    return service.save(video);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    service.remove(id);
  }
}
