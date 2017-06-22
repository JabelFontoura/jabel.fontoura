package br.com.crescer.dao;

// @author jabel.fontoura
import br.com.crescer.aula03.ConnectionUtils;
import br.com.crescer.model.Pais;
import br.com.crescer.model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisDAO implements Dao<Pais> {

  private static final String INSERT = "INSERT INTO Pais (ID, Nome, Sigla) VALUES (?, ?, ?)";
  private static final String UPDATE = "UPDATE Pais SET Nome = ?, Sigla = ? WHERE Id = ?";
  private static final String DELETE = "DELETE FROM Pais WHERE Id = ?";
  private static final String LOAD = "SELECT * FROM Pais WHERE ID = ?";

  @Override
  public void insert(Pais p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(INSERT)) {

      preparedStatement.setLong(1, p.getId());
      preparedStatement.setString(2, p.getNome());
      preparedStatement.setString(3, p.getSigla());

      preparedStatement.executeQuery();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void update(Pais p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(UPDATE)) {

      preparedStatement.setString(1, p.getNome());
      preparedStatement.setString(2, p.getSigla());
      preparedStatement.setLong(3, p.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void delete(Pais p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(DELETE)) {

      preparedStatement.setLong(1, p.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  public Pais loadBy(Long id) {
    final Pais pais = new Pais();
    try (final PreparedStatement preparedStatement
            = ConnectionUtils.abreConexao().prepareStatement(LOAD)) {
      preparedStatement.setLong(1, id);
      try (final ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
          pais.setId(resultSet.getLong("ID"));
          pais.setNome(resultSet.getString("Nome"));
          pais.setSigla(resultSet.getString("Sigla"));
        }
      } catch (final SQLException e) {
        System.err.format("SQLException: %s", e);
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
    return pais;
  }
}
