package br.falc.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.falc.dao.usuario.UsuarioCRUD;
import br.falc.data.usuario.Usuario;

public class TesteAlterarDeletar {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		UsuarioCRUD dao = new UsuarioCRUD();
		Scanner sc = new Scanner(System.in);
		String dado = null;
		int id = 0;
		
		System.out.println("Informe o id para consuta: ");
		id = sc.nextInt();
		sc.next();
		
		usuario = dao.obterUsuarioId(id);
		System.out.println(usuario);

		System.out.println("Informe o nome: ");
		dado = sc.nextLine();
		usuario.setNome(dado);

		System.out.println("Informe o login: ");
		dado = sc.nextLine();
		usuario.setLogin(dado);

		System.out.println("Informe a senha: ");
		dado = sc.nextLine();
		usuario.setSenha(dado);

		System.out.println("Alterando");
		dao.alterar(usuario);
		
		List<Usuario> listaUsuarios = dao.listarUsuarios();
		
		for(Usuario u : listaUsuarios){
			System.out.println(u);
			System.out.println("-------------------");
		}
		
		System.out.println("Excluíndo registro");
		dao.deletar(usuario.getId());

		listaUsuarios = dao.listarUsuarios();
		
		for(Usuario u : listaUsuarios){
			System.out.println(u);
			System.out.println("-------------------");
		}
		
	}
}
