package jmh.gcloud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MSSQLReader {

	public static void main(String[] args) {

		String userName = "profile-service";
		String password = "TheBlur";

		String url = "jdbc:sqlserver://104.154.106.29:1433;databaseName=Nautilus;MultiSubnetFailover=True";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			Statement statement = conn.createStatement();
			//String queryString = "exec nautilus.dbo.PROFILE_GET_LIST 'poulsbopete'";
			String queryString = "exec nautilus.dbo.PROFILE_GET '{297FDA34-A697-48C9-B268-AA7F799B7CC2}'";
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
