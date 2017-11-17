package br.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcseller.Vendedor;


public class VendedorDAO {
	private Connection connection;
	
	public VendedorDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void create(Vendedor vendedor) throws SQLException {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("INSERT INTO Vendedor (login, senha, nome, email, endereco, telefone) VALUES ("
			+ vendedor.getLogin() +", "
			+ vendedor.getSenha() +", "
			+ vendedor.getNome() +", "
			+ vendedor.getEmail() +", "
			+ vendedor.getEndereco() +", "
			+ vendedor.getTelefone() +");");
			
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Vendedor findVendedor(String login) throws SQLException {
		Statement statement = null;
		Vendedor vendedor = new Vendedor();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Vendedor WHERE login = "+ login);
			
			vendedor.setLogin(resultSet.getString("login"));
			vendedor.setSenha(resultSet.getString("senha"));
			vendedor.setNome(resultSet.getString("nome"));
			vendedor.setEmail(resultSet.getString("email"));
			vendedor.setEndereco(resultSet.getString("endereco"));
			vendedor.setTelefone(resultSet.getInt("telefone"));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return vendedor;
	}
	
	public List<Vendedor> getAll() throws SQLException {
		Statement statement = null;
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Vendedor");
			
			while(resultSet.next()) {
				Vendedor vendedor = new Vendedor();
				
				vendedor.setLogin(resultSet.getString("login"));
				vendedor.setSenha(resultSet.getString("senha"));
				vendedor.setNome(resultSet.getString("nome"));
				vendedor.setEmail(resultSet.getString("email"));
				vendedor.setEndereco(resultSet.getString("endereco"));
				vendedor.setTelefone(resultSet.getInt("telefone"));
				
				vendedores.add(vendedor);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return vendedores;
	}
	
	public void update(Vendedor vendedor) throws SQLException {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("UPDATE Vendedor SET "
			+"login = "+ vendedor.getLogin() +", "
			+"senha = "+ vendedor.getSenha() +", "
			+"nome = "+ vendedor.getNome() +", "
			+"email = "+ vendedor.getEmail() +", "
			+"endereco = "+ vendedor.getEndereco() +", "
			+"telefone = "+ vendedor.getTelefone() +";");
			
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(String login) throws SQLException {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeQuery("DELETE FROM Vendedor WHERE login = "+ login);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void closeConnection() throws SQLException {
		try {
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
