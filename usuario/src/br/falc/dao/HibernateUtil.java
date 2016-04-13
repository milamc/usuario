package br.falc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	    .applySettings(cfg.getProperties()).build();
		
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;

	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
