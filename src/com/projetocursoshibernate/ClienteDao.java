package com.projetocursoshibernate;
// Generated 29/06/2020 15:59:08 by Hibernate Tools 5.4.14.Final

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;

/**
 * Home object for domain model class Cliente.
 * @see com.projetoClienteshibernate.Cliente
 * @author Hibernate Tools
 */
public class ClienteDao {

	private static final Logger logger = Logger.getLogger(ClienteDao.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().
                configure(new File("src/META-INFO/hibernate.cfg.xml"))
                .buildSessionFactory();
		return sessionFactory; 
	}

	public void persist(Cliente transientInstance) {
		logger.log(Level.INFO, "persisting Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();			
			logger.log(Level.INFO, "persisting Cliente instance");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void delete(Cliente persistentInstance) {
		logger.log(Level.INFO, "delete Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();			
			logger.log(Level.INFO, "persisting Cliente instance");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}
	
	public void merge(Cliente detachedInstance) {
		logger.log(Level.INFO, "merge Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detachedInstance);
			session.getTransaction().commit();			
			logger.log(Level.INFO, "persisting Cliente instance");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}
	
	public List<Cliente> findAll() {
		logger.log(Level.INFO, "get all Cliente");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Cliente";
			Query query = session.createQuery(hql);
			List<Cliente> Clientes = query.list();
			session.getTransaction().commit();			
			return Clientes;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}		
	}
	
	public Cliente find(long cdCliente) {
		logger.log(Level.INFO, "getting Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Cliente instance = (Cliente) sessionFactory.getCurrentSession().get(
					"com.projetocursoshibernate.Cliente", cdCliente);
			session.getTransaction().commit();
			if (instance == null) {
				logger.log(Level.INFO, "instance found");
			} else {
				logger.log(Level.INFO, "instace ok");
			}
			return instance;			
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge find failed", re);
			throw re;
		}		
	}
}
