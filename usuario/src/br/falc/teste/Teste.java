package br.falc.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.falc.dao.usuario.UsuarioCRUD;
import br.falc.data.usuario.Usuario;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		Scanner sc = new Scanner(System.in);
		String dado = null;
		int id = 0;
		
		System.out.println("Informe o nome: ");
		dado = sc.nextLine();
		usuario.setNome(dado);

		System.out.println("Informe o login: ");
		dado = sc.nextLine();
		usuario.setLogin(dado);

		System.out.println("Informe a senha: ");
		dado = sc.nextLine();
		usuario.setSenha(dado);

		UsuarioCRUD dao = new UsuarioCRUD();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = dao.listarUsuarios();
		
		for(Usuario u : listaUsuarios){
			System.out.println(u);
			System.out.println("-------------------");
		}
		
		dao.salvar(usuario);
		dao.listarUsuarios();

		listaUsuarios = dao.listarUsuarios();
		
		for(Usuario u : listaUsuarios){
			System.out.println(u);
			System.out.println("-------------------");
		}
		
		System.out.println("Informe o id para consuta: ");
		id = sc.nextInt();
		
		Usuario novo = dao.obterUsuarioId(id);
		System.out.println(novo);
		
	}
	
}
