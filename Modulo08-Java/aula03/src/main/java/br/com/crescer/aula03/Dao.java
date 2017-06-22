package br.com.crescer.aula03;

 // @author jabel.fontoura
 
public interface Dao<T> {
  
  void insert(T t);
  void update(T t);
  void delete(T t);
  
}
