package vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConexion {
	private static String db_ = "database=test";
	private static String login_ = "1234";
	private static String password_ = "1234";
	private static String url_ = "jdbc:mysql://localhost:3306/" + db_;
	private static Connection connection_;
	//private static Statement st_ = null;
	
	public static Connection getPruebaConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection_ = DriverManager.getConnection(url_,login_, password_);
			return connection_;
		}		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
