package br.com.crescer.tema;

// @author Jabel
import br.com.crescer.aula03.ConnectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtilsImpl implements SQLUtils {

  @Override
  public void runFile(String filename) {
    String[] comandos = read(filename).split(";");

    try (final Statement statement = ConnectionUtils.abreConexao().createStatement()) {
      for (String s : comandos) 
        statement.executeQuery(s);
      
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public String executeQuery(String query) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void importCSV(File file) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public File importCSV(String query) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public String read(String string) {
    try {
      final Reader reader = new FileReader(string);
      final BufferedReader bufferReader = new BufferedReader(reader);

      final StringBuilder sb = new StringBuilder();

      bufferReader.lines().forEach(l -> sb.append(l + "\n"));

      return sb.toString();

    } catch (Exception ex) {
      return null;
    }
  }

}
