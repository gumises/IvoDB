package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.mapped.Magazyn;
import database.mapped.Towar;
import database.mapped.Vat;

public class DatabaseConnector {

	public DatabaseConnector() {
		//TODO for testing, delete in the future
		for(int i = 0; i < 15; i ++)
			System.out.println(getMagazyn(i));
	}
	
	/** Checks if products is already in the database. */
	public static boolean isProductExist(String name) {
		//TODO implement
		return true;
	}
	
	/** Checks if its suitable in the database. */
	public static boolean isProductAmount(int amount) {
		//TODO implement
		return false;
	}
	
	/** Returns Vat object by id. */
	public static Vat getVat(int id) {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Vat vat = (Vat) session.get(Vat.class, id);
        
        session.getTransaction().commit();
        session.close();
        return vat;
    }
	
	/** Returns Towar objectby id. */
	public static Towar getTowar(int id) {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Towar towar = (Towar) session.get(Towar.class, id);
        
        session.getTransaction().commit();
        session.close();
        return towar;
    }
	
	/** Returns Magazyn object by towar id. */
	public static Magazyn getMagazyn(int id) {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Magazyn magazyn = (Magazyn) session.get(Magazyn.class, id);
        
        session.getTransaction().commit();
        session.close();
        return magazyn;
    }
	
	public static void main(String [] args) {
		new DatabaseConnector();
	}
}
