package br.falc.dao.usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

	public Usuario obterUsuarioId(int id){

		Usuario usuario = null;
		
		Session ses = session.openSession();
		Transaction tx = null;
		Criteria criteria = null;
		
		try{
			tx = ses.beginTransaction();
			
			criteria = ses.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("id", id));
			usuario = (Usuario) criteria.uniqueResult();
			
			tx.commit();

		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			ses.close();
		}
		
		return usuario;
	}
	
	public void alterar(Usuario usuario){
		Session ses = session.openSession();
		Transaction tx = null;
		try{
			tx = ses.beginTransaction();
			ses.update(usuario);
			tx.commit();			
		}catch(HibernateException e){
			if (tx != null){
				tx.rollback();
				System.out.println("Erro: "+ e);
			}
		}finally{
			ses.close();			
		}
		
	}
	
	
	public void deletar(int id){
		Session ses = session.openSession();
		Transaction tx = null;
		try{
			tx = ses.beginTransaction();
			Usuario usuario = (Usuario) ses.byId(Usuario.class).load(id);
			ses.delete(usuario);
			tx.commit();			
		}catch(HibernateException e){
			if (tx != null){
				tx.rollback();
				System.out.println("Erro: "+ e);
			}
		}finally{
			ses.close();			
		}
		
	}

	public List<Usuario> obterUsuarioNome(String nome){

		List<Usuario> usuarios = null;
		
		Session ses = session.openSession();
		Transaction tx = null;
		Criteria criteria = null;
		
		try{
			tx = ses.beginTransaction();
			
			criteria = ses.createCriteria(Usuario.class);
			criteria.add(Restrictions.ilike("nome", nome));
			criteria.addOrder(Order.asc("nome"));
			List lista = criteria.list();
			usuarios = new ArrayList<Usuario>();
			
			for(Object o : lista){
				Usuario u = (Usuario) o; 
				usuarios.add(u);
			}
			tx.commit();

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
