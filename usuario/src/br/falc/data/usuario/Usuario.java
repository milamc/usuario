package br.falc.data.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column
	private String nome;

	public Usuario() { }

	public Usuario(int id, String login, String senha, String nome) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		String dados = "--Usuario--"+"\n"+
				"Id: "+this.id+"\n"+
				"Nome: "+this.nome+"\n"+
				"Login: "+this.login+"\n"+
				"Senha: "+this.senha+"\n";
		return dados;
	}
	
}
