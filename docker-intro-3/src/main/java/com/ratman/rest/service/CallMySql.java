package com.ratman.rest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/callmysql")
public class CallMySql {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		StringBuilder sb = new StringBuilder();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://jmhdb.c2d6mpyvf7kc.us-east-1.rds.amazonaws.com:3306/jmhdb", "jmh", "stupid911");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select tutorial_author from tutorials_tbl");
			while (rs.next()) {
				sb.append(rs.getString(1));
			}
			con.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return sb.toString();
	}
}
