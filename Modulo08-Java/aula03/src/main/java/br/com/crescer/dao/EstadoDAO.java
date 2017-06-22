package br.com.crescer.dao;

// @author jabel.fontoura
import br.com.crescer.aula03.ConnectionUtils;
import br.com.crescer.model.Estado;
import br.com.crescer.model.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO implements Dao<Estado> {

  private static final String INSERT = "INSERT INTO Estado (ID, Nome, UF, Pais) VALUES (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE Estado SET Nome = ?, Uf = ?, Pais = ? WHERE Id = ?";
  private static final String DELETE = "DELETE FROM Estado WHERE Id = ?";
  private static final String LOAD = "SELECT * FROM Estado WHERE Id = ?";
  
  @Override
  public void insert(Estado t) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(INSERT)) {

      preparedStatement.setLong(1, t.getId());
      preparedStatement.setString(2, t.getNome());
      preparedStatement.setString(3, t.getUf());
      preparedStatement.setLong(4, t.getIdPais());

      preparedStatement.executeQuery();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void update(Estado t) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(UPDATE)) {

      preparedStatement.setString(1, t.getNome());
      preparedStatement.setString(2, t.getUf());
      preparedStatement.setLong(3, t.getIdPais());
      preparedStatement.setLong(4, t.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void delete(Estado t) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(DELETE)) {

      preparedStatement.setLong(1, t.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  public Estado loadBy(Long id) {
    final Estado estado = new Estado();
    try (final PreparedStatement preparedStatement
            = ConnectionUtils.abreConexao().prepareStatement(LOAD)) {
      preparedStatement.setLong(1, id);
      try (final ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
          estado.setId(resultSet.getLong("ID"));
          estado.setNome(resultSet.getString("Nome"));
          estado.setUf(resultSet.getString("uf"));
          estado.setIdPais(resultSet.getLong("Pais"));
        }
      } catch (final SQLException e) {
        System.err.format("SQLException: %s", e);
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
    return estado;
  }
}
