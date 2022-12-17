package context;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import entity.Account;
import entity.Inforaccount;
public class HibernateUtil {
    
//	private final static SessionFactory FACTORY;
//	
//	static {
//		Configuration conf = new Configuration ();
//		Properties pros = new Properties();
//		pros.put (Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//		pros.put (Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//		pros.put (Environment.URL, "jdbc:mysql://localhost:3306/quanlydetai");
//		pros.put (Environment.USER, "root");
//		pros.put (Environment.PASS, "123456789");
//		pros.put (Environment.SHOW_SQL, "true");
//		pros.put(Environment.AUTOCOMMIT, "true");
//		pros.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//		pros.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
//		
//		
//		conf.setProperties(pros);
//		
//		conf.addAnnotatedClass(Account.class);
//		conf.addAnnotatedClass(ChuyenNganh.class);
//		conf.addAnnotatedClass(DangKy.class);
//		conf.addAnnotatedClass(Inforaccount.class);
//		conf.addAnnotatedClass(DeTai.class);
//		
//		ServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.applySettings(conf.getProperties()).build();
//
//		FACTORY  = conf.buildSessionFactory(registry);
//		
//	}
//	public static SessionFactory getSessionFactory(){
//		return FACTORY;
//	}
	private static SessionFactory sessionFactory;

	   private static SessionFactory buildSessionFactory() {
	      try {
	         // Create the SessionFactory from hibernate.cfg.xml
	         Configuration configuration = new Configuration();
	         configuration.configure("hibernate.cfg.xml");

	         return configuration.buildSessionFactory();
	      }
	      catch (Throwable ex) {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
	   }

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null)
	         sessionFactory = buildSessionFactory();
	      return sessionFactory;
	   }
}