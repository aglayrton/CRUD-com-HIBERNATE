package com.projetocursoshibernate;

// Generated Jan 24, 2017 8:17:50 PM by Hibernate Tools 4.3.1

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Home object for domain model class Pagamento.
 * @see com.abctreinamentos.Pagamento
 * @author Hibernate Tools
 */
public class PagamentoDAO {
	private static final Logger logger = Logger.getLogger(ClienteDao.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().
                configure(new File("src/META-INFO/hibernate.cfg.xml"))
                .buildSessionFactory();
		return sessionFactory; 
	}

	public void persist(Pagamento transientInstance) {
		logger.log(Level.INFO, "persisting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();			
			logger.log(Level.INFO, "persisting Pagamento instance");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void delete(Pagamento persistentInstance) {
		logger.log(Level.INFO, "delete Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();			
			logger.log(Level.INFO, "persisting Pagamento instance");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}
	
	public void merge(Pagamento detachedInstance) {
		logger.log(Level.INFO, "merge Cliente instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detachedInstance);
			session.getTransaction().commit();			
			logger.log(Level.INFO, "persisting Pagamento instance");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}
	
	public List<Pagamento> findAll() {
		logger.log(Level.INFO, "get all Pagamento");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Pagamento";
			Query query = session.createQuery(hql);
			List<Pagamento> Pagamentos = query.list();
			session.getTransaction().commit();			
			return Pagamentos;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}		
	}
	
	public Pagamento find(PagamentoId id) {
		logger.log(Level.INFO, "getting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Pagamento instance = (Pagamento) sessionFactory.getCurrentSession().get(
					"com.projetocursoshibernate.Pagamento", id);
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
