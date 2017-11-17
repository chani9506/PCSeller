package br.com.pcseller;

public class Vendedor {
	private String login;
	private String senha;
	private String nome;
	private String email;
	private String endereco;
	private int telefone;
	
	public Vendedor() {
	
	}

	public Vendedor(String login, String senha, String nome, String email, String endereco, int telefone) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
