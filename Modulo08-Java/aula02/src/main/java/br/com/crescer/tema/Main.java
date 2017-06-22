package br.com.crescer.tema;

// @author Jabel Fontoura

public class Main {
  
  public static void main(String[] args) {
    // Exercicio 1;
    FileUtilsImpl utils = new FileUtilsImpl();
    
    System.out.println(utils.mv("D:\\Classes\\CWI\\testes\\novoArquivo.txt", "D:\\Classes\\CWI\\novoArquivo.txt"));
   
  }
}