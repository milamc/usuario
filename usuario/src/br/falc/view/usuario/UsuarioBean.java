package br.falc.view.usuario;

public class UsuarioBean {

	private String nome;
	private String email;
	private String senha;
	
	public String novo(){
		return "usuario";
	}
	
	public String salvar(){
		return "sucesso";
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
