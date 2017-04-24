package jmh.scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyAurora {

	//aurora-test-cluster.cluster-c2d6mpyvf7kc.us-east-1.rds.amazonaws.com:3306
	
	public static void main(String... args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://aurora-test2-cluster.cluster-c2d6mpyvf7kc.us-east-1.rds.amazonaws.com/mydb2", "admin", "stupid911");
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
