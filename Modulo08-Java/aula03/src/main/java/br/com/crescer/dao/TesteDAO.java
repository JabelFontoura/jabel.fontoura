package br.com.crescer.dao;

// @author jabel.fontoura
import br.com.crescer.aula03.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

public class TesteDAO {

  private static final String DROP_TABLE = "DROP TABLE TESTE";
  private static final String INSERT_TESTE = " INSERT INTO TESTE (ID, NOME) VALUES (?,?)";
  private static final String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
          + "  ID NUMBER(8) NOT NULL,\n"
          + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
          + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
          + ")";

  public void dropTable() {
    try (final Statement statement = ConnectionUtils.abreConexao().createStatement()) {
      statement.executeQuery(DROP_TABLE);
    } catch (SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  public void createTable() {
    try (final Statement statement = ConnectionUtils.abreConexao().createStatement()) {
      statement.executeQuery(CREATE_TABLE);
    } catch (SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  public void insertIntoTable() {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(INSERT_TESTE)) {
      final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());

      for (Long id : list) {
        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, String.format("%s pessoa de 999", id));
        preparedStatement.executeUpdate();
      }

    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }
}
