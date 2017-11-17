package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.pcseller.Cliente;

public class ClienteDAO {
	private Connection connection = null;
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://143.107.102.5:3306/t2g2",
					"t2g2", "jx&XscUw");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ClienteDAO() throws SQLException {
		this.getConnection();
	}
	
	public boolean create (Cliente cliente) throws SQLException {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("INSERT INTO Cliente VALUES (" + 
			cliente.getCpf() + ", '" + cliente.getNome() + "', '" + cliente.getEndereco() + "', '" + 
					cliente.getEmail() + "', " + cliente.getTelefone() + ")");
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(statement != null) {
				statement.close();
			}			
		}
	}
	
	public Cliente findByCPF(int cpf) throws SQLException {
		Statement statement = null;
		Cliente cliente = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente WHERE cpf = " + cpf);
			
			while(resultSet.next()) {
				cliente = new Cliente(
						resultSet.getInt("cpf"),
						resultSet.getString("nome"),
						resultSet.getString("endereco"),
						resultSet.getString("email"),
						resultSet.getInt("telefone")
						);
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				statement.close();
			}			
		}
		return cliente;
	}
	
	public boolean update(Cliente cliente) throws SQLException {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("UPDATE Cliente SET nome = " + 
			cliente.getNome() + ", endereco = " + cliente.getEndereco() + ", email = " + cliente.getEmail() + 
			", telefone = " + cliente.getTelefone() + " WHERE cpf = " + cliente.getCpf());
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(statement != null) {
				statement.close();
			}			
		}
	}
	
	public boolean remove(int cpf) throws SQLException {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("DELETE FROM Cliente WHERE cpf = " + cpf);
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(statement != null) {
				statement.close();
			}			
		}
	}
}
