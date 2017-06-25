package br.com.crescer.aula04;

// @author Jabel
import br.com.crescer.aula04.dao.CrudDao;
import br.com.crescer.aula04.dao.GenericDAO;
import br.com.crescer.aula04.model.Genero;
import br.com.crescer.aula04.model.Video;
import java.sql.Date;

public class Main {

  public static void main(String[] args) {
    CrudDao GeneroDao = new GenericDAO<Genero, Long>(Genero.class);
    Genero genero = new Genero();
    genero.setDescricao("Test aaaae");
    //GeneroDao.save(genero);

    //genero = (Genero) GeneroDao.findAll().get(0);
    System.out.println(genero.getId());

    
    CrudDao videoDao = new GenericDAO<Video, Long>(Video.class);
    Video video = new Video();
    video.setNome("Teste video");
    video.setDataLancamento(new Date(2017, 06, 25));
    video.setQuantidadeEstoque(5);
    video.setValor(15);
    video.setGenero(genero);
    
    System.out.println(video.getId());
    
    videoDao.save(video);
    
    System.out.println(videoDao.findAll().get(0));
    
    
  }
}
