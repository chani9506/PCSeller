package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://143.107.102.5/t2g2", "t2g2", "jx&XscUw");
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
