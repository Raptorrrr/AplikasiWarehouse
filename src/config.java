import java.sql.*;

public class config {

	private static Connection MySQLConfig;
	
	public static Connection configDB() throws SQLException, ClassNotFoundException{
		try {
			String url = "jdbc:mysql://localhost:3306/gudang";
			String user = "root";
			String pass = "";
			Class.forName("com.mysql.jdbc.Driver");
			MySQLConfig = DriverManager.getConnection(url,user,pass);
		}catch(SQLException e) {
			System.out.println("koneksi ke Database gagal" + e.getMessage());
		}
		return MySQLConfig;
	}

}

