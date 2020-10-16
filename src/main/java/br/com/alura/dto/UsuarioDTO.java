package br.com.alura.dto;

public class UsuarioDTO {

	public UsuarioDTO() { }

	public UsuarioDTO(String nome, String cpf, String username, String role) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.role = role;
	}

	private String nome;
	private String cpf;
	private String username;
	private String password;
	private String role;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
