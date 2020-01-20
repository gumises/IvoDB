package newdatabase.connector;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import newdatabase.HibernateUtil;
import newdatabase.Towar;
import newdatabase.Vat;
import newdatabase.Magazyn;

public class TowarConnector {

	/** Returns Towar object by id. */
	public static Towar getTowar(int id) {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Towar towar = (Towar) session.get(Towar.class, id);
        
        session.getTransaction().commit();
        session.close();
        return towar;
    }
	
	/** Checks if products is already in the database. */
	public static boolean isTowarExist(String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Towar> towars = session.createSQLQuery("SELECT nazwa from Towar WHERE nazwa='"+name+"'").list();
        session.getTransaction().commit();
        session.close();
        if(towars.isEmpty())
        	return false;
        else
        	return true;
	}
	
	/** Checks if products is already in the database. */
	public static boolean tryChangeTowarAmount(String name, int amount, boolean status) {
		
		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Towar> towars = session.createQuery("from Towar WHERE nazwa='"+name+"'").list();
        Magazyn magazyn = towars.get(0).getMagazyn();
        session.getTransaction().commit();
        session.close();
        if (magazyn == null || magazyn.getIlosc() < amount)
        	return false;
        else
        	return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Returns list of Towars. */
	public static List<Towar> getTowars() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        List<Towar> towars = session.createQuery("from Towar").list();
        
        session.getTransaction().commit();
        session.close();
        return towars;
    }
	
	/** Inserts new move into moves table. */
	public static void insertTowar(Vat vat, String nazwa, double cena) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Towar towar = new Towar(vat, nazwa, cena);
        
        session.save(towar);
        session.getTransaction().commit();
        session.close();
	}

    public static boolean isTowarAmount(String towar5, int i) {
	    return true;
    }
}
