package br.com.crescer.dao;

 // @author jabel.fontoura
 
public interface Dao<T> {
  
  void insert(T t);
  void update(T t);
  void delete(T t);
  T loadBy(Long id);
}
