package br.com.crescer.aula03;

// @author jabel.fontoura
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtils {

  private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
  private static final String user = "System";
  private static final String pass = "oracle";
  
  private ConnectionUtils() { }

  public static Connection abreConexao() throws SQLException {
    return DriverManager.getConnection(url, user, pass);
  }
}
