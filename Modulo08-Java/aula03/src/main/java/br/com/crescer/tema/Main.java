package br.com.crescer.tema;

 // @author Jabel
import java.io.File;

public class Main {
  public static void main(String[] args) {
    SQLUtils sql = new SQLUtilsImpl();
    
    //sql.runFile("C:\\Temp\\teste.sql");
    
    //System.out.println(sql.executeQuery("SELECT * FROM Estado"));
    
    //sql.importCSV(new File("C:\\Temp\\Pais.csv"));
    
    sql.exportCSV("SELECT * FROM PAIS");
  }
}