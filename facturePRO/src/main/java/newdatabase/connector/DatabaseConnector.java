package newdatabase.connector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import newdatabase.HibernateUtil;
import newdatabase.Magazyn;
import newdatabase.Towar;
import newdatabase.Vat;

public class DatabaseConnector {

	/** Checks if its suitable in the database. */
	public static boolean isProductAmount(int amount) {
		//TODO implement
		return false;
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
