package br.com.crescer.aula04;

// @author Jabel
import br.com.crescer.aula04.dao.CrudDao;
import br.com.crescer.aula04.dao.GenericDAO;
import br.com.crescer.aula04.model.Genero;
import static javafx.scene.input.KeyCode.T;

public class Main {

  public static void main(String[] args) {
    CrudDao dao = new GenericDAO<Genero, Long>(Genero.class);
    Genero genero = new Genero();
    genero.setDescricao("Teste");
//    dao.save(genero);

    genero = (Genero) dao.findAll().get(0);
    System.out.println(genero.getDescricao());
    
    dao.remove(genero);
    
  }
}
