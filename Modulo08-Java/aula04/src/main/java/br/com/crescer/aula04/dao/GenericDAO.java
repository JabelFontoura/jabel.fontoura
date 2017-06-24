package br.com.crescer.aula04.dao;

 // @author Jabel
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.Session;
 
public class GenericDAO<T, ID> implements CrudDao<T, ID>{
  
  private final EntityManager em = Persistence.createEntityManagerFactory("CRESCER").createEntityManager();
  private final Session session;
  private Class<T> entity;

  public GenericDAO(Class<T> entity) {
    this.entity = entity;
    em.getTransaction().begin();
    this.session = em.unwrap(Session.class);
  }
  
  @Override
  public T save(T e) {
    session.saveOrUpdate(e);
    session.getTransaction().commit();
    return e;
  }

  @Override
  public void remove(T e) {
    session.delete(e);
    session.getTransaction().commit();
  }

  @Override
  public T loadById(ID id) {
    return em.find(entity, id);
  }

  @Override
  public List<T> findAll() {
    return session.createCriteria(entity).list();
  }
  
  public void close() {
    session.close();
    em.close();
  }
}