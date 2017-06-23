package br.com.crescer.tema;

 // @author Jabel
 
public class Main {
  public static void main(String[] args) {
    SQLUtils sql = new SQLUtilsImpl();
    
    sql.runFile("C:\\Temp\\teste.sql");
  }
}