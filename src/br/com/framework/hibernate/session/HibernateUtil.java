package br.com.framework.hibernate.session;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;

/**
 * responsavel por estabelecer conexao com o Hibernate
 * @author Everson souza
 */
@ApplicationScoped
public class HibernateUtil implements Serializable {
	
	private static  final long serialVersionUID = 1L;
	public static String JAVA_COMP_ENV_JDBC_DATA_SOURCE = "java:/comp/env/jdbc/datasource/";
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * responsavel por ler o arquivo de configuraçao hibernate.cfg.xml
	 * @return sessionFactory
	 */
	private static SessionFactory buildSessionFactory(){
		
		try {
			if(sessionFactory == null){
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("erro ao criar conexao sessiona factory");
		}	
	}
	
	/**
	 * 
	 * @return a sessionFactory construida no metodo buildSessionFactory
	 */
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	/**
	 * retorna a sessao do SessionFactory
	 * @return Session
	 */
	public static Session getCurrentSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	/**
	 * abre uma nova sessao do sessionFactory
	 * @return Session
	 */
	public static Session openSession(){
			
		if(sessionFactory == null){
		 	 buildSessionFactory();
	    }
		 return sessionFactory.openSession();
	}	
	/**
	 * obtem a connection do provedor de conexoes configurado
	 * @return Connection SQL
	 * @throws SQLException
	 */
	public static Connection getConnectionProvider() throws SQLException {
		return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();
	}
}
