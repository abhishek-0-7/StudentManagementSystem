import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  private static final String DB_USER = "javabked";
  private static final String DB_PASSWORD = "mystudents";

  static {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
  }
}
