package jmh.scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MySql {

	public static void main(String... args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://jmhdb2-cluster.cluster-cgurkjeueo9b.us-west-2.rds.amazonaws.com:3306/mydb", "jmhdb", "stupid911");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select name from pet");
			while (rs.next()) {
				sb.append(rs.getString(1) + "\n");
			}
			con.close();
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
