package br.com.crescer.tema;

// @author Jabel
import br.com.crescer.aula03.ConnectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtilsImpl implements SQLUtils {

  @Override
  public void runFile(String filename) {
    String[] comandos = read(filename).split(";");

    try (final Statement statement = ConnectionUtils.abreConexao().createStatement()) {
      for (String s : comandos) {
        statement.executeQuery(s);
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public String executeQuery(String query) {
    StringBuilder result = new StringBuilder();
    try (final PreparedStatement preparedStatement
            = ConnectionUtils.abreConexao().prepareStatement(query)) {
      try (final ResultSet resultSet = preparedStatement.executeQuery()) {
        ResultSetMetaData lines = resultSet.getMetaData();
        int colunas = lines.getColumnCount();
        for (int i = 1; i < colunas; i++) {
          result.append(lines.getColumnName(i)).append(" ");
        }
        while (resultSet.next()) {
          for (int i = 0; i < colunas; i++) {
            result.append(resultSet.getString(i + 1)).append(" ");
          }
          result.append("\n");
        }
      } catch (final SQLException e) {
        System.err.format("SQLException: %s", e);
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
    return result.toString();
  }

  @Override
  public void importCSV(File file) {
    String[] linhas = read(file.getAbsolutePath()).split("\n");
    try (final PreparedStatement statement = ConnectionUtils.abreConexao().prepareStatement(criarInsert(file, linhas))) {
      for (String s : linhas) {
        String[] valores = s.split(",");
        for (int i = 1; i <= valores.length; i++) {
          statement.setObject(i, valores[i - 1]);
        }
        statement.executeQuery();
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public File exportCSV(String query) {
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

  public String criarInsert(File file, String linhas[]) {
    StringBuilder sb = new StringBuilder("INSERT INTO ");
    String tabela = file.getName();
    int bindings = countOcorrences(linhas[0], ",") + 1;

    sb.append(tabela.substring(0, tabela.indexOf(".")));
    sb.append(" VALUES (");
    for (int i = 0; i < bindings; i++) {
      sb.append("?,");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append(")");

    return sb.toString();
  }

  public int countOcorrences(String string, String busca) {
    return string.length() - string.replace(busca, "").length();
  }

}
