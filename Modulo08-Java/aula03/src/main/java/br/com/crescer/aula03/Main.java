package br.com.crescer.aula03;

 // @author jabel.fontoura
import br.com.crescer.dao.CidadeDAO;
import br.com.crescer.dao.EstadoDAO;
import br.com.crescer.model.Cidade;
import br.com.crescer.model.Estado;
 
public class Main {
  
  public static void main(String[] args) {
    EstadoDAO dao = new EstadoDAO();
    Estado e = new Estado();
    e.setId((long) 1);
    e.setNome("Acreee");
    e.setUf("AC");
    e.setIdPais((long) 1);
    
    dao.update(e);
  }
}
