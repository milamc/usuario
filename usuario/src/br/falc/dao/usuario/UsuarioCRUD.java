package br.falc.dao.usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.falc.dao.HibernateUtil;
import br.falc.data.usuario.Usuario;

public class UsuarioCRUD {

	private static SessionFactory session = null;
	
	public UsuarioCRUD() {
		session = HibernateUtil.getSessionFactory();		
	}
	
	public Integer salvar(Usuario usuario){
		Session ses = session.openSession();
		Transaction tx = null;
		Integer id = null;
		try{
			tx = ses.beginTransaction();
			id = (Integer) ses.save(usuario);
			tx.commit();			
		}catch(HibernateException e){
			if (tx != null){
				tx.rollback();
				System.out.println("Erro: "+ e);
			}
		}finally{
			ses.close();			
		}
		
		return id;
	}

	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = null;
		
		Session ses = session.openSession();
		Transaction tx = null;
		
		try{
			tx = ses.beginTransaction();
			List lista = ses.createCriteria(Usuario.class).list();
			tx.commit();
			usuarios = new ArrayList<Usuario>();
			
			for(Object o : lista){
				Usuario u = (Usuario) o; 
				usuarios.add(u);
			}
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			ses.close();
		}
		
		return usuarios;
	}
	
}
