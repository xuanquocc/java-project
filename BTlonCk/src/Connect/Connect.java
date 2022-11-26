package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;user=sa;password=sa";
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected");
			}
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Cannot connect database, " + ex);
		}
		return conn;
	}
}
