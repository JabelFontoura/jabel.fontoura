package br.com.crescer.aula03;

// @author jabel.fontoura

import br.com.crescer.dao.TesteDAO;


public class ExemploDDL {
  
    public static void main(String[] args) {
      TesteDAO dao = new TesteDAO();
      
      dao.dropTable();
      dao.createTable();
      dao.insertIntoTable();
    }
}