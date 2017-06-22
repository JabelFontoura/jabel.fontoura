package br.com.crescer.aula03;

// @author jabel.fontoura
import br.com.crescer.model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO implements Dao<Pessoa> {

  private static final String INSERT = "INSERT INTO Pessoa (ID, NOME) VALUES (?,?)";
  private static final String DELETE = "DELETE FROM Pessoa WHERE Id = ?";
  private static final String UPDATE = "UPDATE Pessoa SET Nome = ? WHERE Id = ?";

  @Override
  public void insert(Pessoa p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(INSERT)) {

      preparedStatement.setLong(1, p.getId());
      preparedStatement.setString(2, p.getNome());

      preparedStatement.executeQuery(INSERT);
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void update(Pessoa p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(UPDATE)) {

      preparedStatement.setString(1, p.getNome());
      preparedStatement.setLong(2, p.getId());

      preparedStatement.executeUpdate(UPDATE);
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }

  @Override
  public void delete(Pessoa p) {
    try (final PreparedStatement preparedStatement = ConnectionUtils.abreConexao().prepareStatement(DELETE)) {

      preparedStatement.setLong(1, p.getId());

      preparedStatement.executeUpdate(DELETE);
    } catch (final SQLException e) {
      System.err.format("SQLException: %s", e);
    }
  }
}
