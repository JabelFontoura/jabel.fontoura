package br.com.crescer.aula04;

 // @author Jabel
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Connection {
  
private static final EntityManager em = Persistence.createEntityManagerFactory("CRESCER").createEntityManager();
  
  public static EntityManager getEntityManager() {
    return em;
  }
  
  public static void closeEntityManager() {
    em.close();
  }
}