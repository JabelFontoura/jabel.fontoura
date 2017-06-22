package br.com.crescer.dao;

// @author jabel.fontoura
import br.com.crescer.aula03.ConnectionUtils;
import br.com.crescer.model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO implements Dao<Pessoa> {

  private static final String INSERT = "INSERT INTO Pessoa (ID, NOME) VALUES (?,?)";
  private static final String DELETE = "DELETE FROM Pessoa WHERE Id = ?";
  private static final String UPDATE = "UPDATE Pessoa SET Nome = ? WHERE Id = ?";
  private static final String LOAD = "SELECT * FROM PESSOA WHERE ID = ?";

  @Override
  public void insert(Pessoa p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(INSERT)) {

      preparedStatement.setLong(1, p.getId());
      preparedStatement.setString(2, p.getNome());

      preparedStatement.executeQuery();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void update(Pessoa p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(UPDATE)) {

      preparedStatement.setString(1, p.getNome());
      preparedStatement.setLong(2, p.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void delete(Pessoa p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(DELETE)) {

      preparedStatement.setLong(1, p.getId());

      preparedStatement.executeUpdate();
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public Pessoa loadBy(Long id) {
    final Pessoa pessoa = new Pessoa();
    try (final PreparedStatement preparedStatement
            = ConnectionUtils.abreConexao().prepareStatement(LOAD)) {
      preparedStatement.setLong(1, id);
      try (final ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
          pessoa.setId(resultSet.getLong("ID"));
          pessoa.setNome(resultSet.getString("NOME"));
        }
      } catch (final SQLException e) {
        System.err.format("SQLException: %s", e);
      }
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
    return pessoa;
  }
}
