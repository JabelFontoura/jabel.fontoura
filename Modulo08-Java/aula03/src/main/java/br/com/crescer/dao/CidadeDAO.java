package br.com.crescer.dao;

// @author jabel.fontoura
import br.com.crescer.aula03.ConnectionUtils;
import br.com.crescer.model.Cidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.net.aso.p;

public class CidadeDAO implements Dao<Cidade> {

  private static final String INSERT = "INSERT INTO Cidade (ID, Nome, Estado) VALUES (?, ?, ?)";
  private static final String UPDATE = "UPDATE Cidade SET Nome = ?, Estado = ? WHERE Id = ?";
  private static final String DELETE = "DELETE FROM Cidade WHERE Id = ?";
  private static final String LOAD = "SELECT * FROM Cidade WHERE ID = ?";

  @Override
  public void insert(Cidade c) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(INSERT)) {

      preparedStatement.setLong(1, c.getId());
      preparedStatement.setString(2, c.getNome());
      preparedStatement.setLong(3, c.getIdEstado());

      preparedStatement.executeQuery();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void update(Cidade c) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(UPDATE)) {

      preparedStatement.setString(1, c.getNome());
      preparedStatement.setLong(2, c.getIdEstado());
      preparedStatement.setLong(3, c.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void delete(Cidade c) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(DELETE)) {

      preparedStatement.setLong(1, c.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public Cidade loadBy(Long id) {
    final Cidade cidade = new Cidade();
    try (final PreparedStatement preparedStatement
            = ConnectionUtils.abreConexao().prepareStatement(LOAD)) {
      preparedStatement.setLong(1, id);
      try (final ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
          cidade.setId(resultSet.getLong("ID"));
          cidade.setNome(resultSet.getString("Nome"));
          cidade.setIdEstado(resultSet.getLong("Estado"));
        }
      } catch (final SQLException e) {
        System.err.format("SQLException: %s", e);
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
    return cidade;
  }
}
