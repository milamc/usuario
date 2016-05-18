package br.falc.view.usuario;

import java.util.ArrayList;
import java.util.List;

import br.falc.dao.usuario.UsuarioCRUD;
import br.falc.data.usuario.Usuario;

public class UsuarioBean {

	private Usuario usuario;
	private List<Usuario> usuarios;
	private String nome;
	private String login;
	private String senha;
	private UsuarioCRUD usuarioCRUD;
	
	public String novo(){
		return "usuario";
	}
	
	public String salvar(){
		
		UsuarioCRUD crud = new UsuarioCRUD();
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		crud.salvar(usuario);
		return "sucesso";
	}

	public String listar(){
		UsuarioCRUD crud = new UsuarioCRUD();
		usuarios = crud.listarUsuarios();
		//setUsuarios(getUsuarioCRUD().listarUsuarios());
		return "lista";
	}
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			usuarios = new ArrayList<Usuario>();
		}
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	public UsuarioCRUD getUsuarioCRUD() {
		if(usuarioCRUD == null){
			usuarioCRUD = new UsuarioCRUD();
		}
		return usuarioCRUD;
	}
	public void setUsuarioCRUD(UsuarioCRUD usuarioCRUD) {
		this.usuarioCRUD = usuarioCRUD;
	}
}
