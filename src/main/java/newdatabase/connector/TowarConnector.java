package newdatabase.connector;

import newdatabase.HibernateUtil;
import newdatabase.Magazyn;
import newdatabase.Towar;
import newdatabase.Vat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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
	
	/** Tries change amount of specific product. */
	public static void changeTowarAmount(String name, int amount) throws Exception {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
		
        try {
        	List<Towar> towars = session.createQuery("from Towar WHERE nazwa='"+name+"'").list();
        	Towar towar = towars.get(0);
        	Magazyn magazyn = towar.getMagazyn();
        	if(magazyn == null) {
        		magazyn = new Magazyn(towar, 0);
        		session.save(magazyn);
        	}
        	magazyn.setIlosc(magazyn.getIlosc() + amount);
        	session.save(magazyn);
        	transaction.commit();
        }
		catch (Exception exception) {
			transaction.rollback();
			throw exception;
		}
        finally {
        	session.close();
        }
	}
	
	/** Checks if products is already in the database. */
	public static void removeTowar(String name) throws Exception{
		  
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
		try {
			List<Towar> towars = session.createQuery("from Towar WHERE nazwa='"+name+"'").list();
			Magazyn magazyn = towars.get(0).getMagazyn();
			session.delete(magazyn);
			transaction.commit();
		}
		catch (Exception exception) {
			transaction.rollback();
			throw exception;
		}
		finally {
	        session.close();
		}
	}
	
	/** Returns list of Towars. */
	public static List<Towar> getTowars(String name, Double maxPrice, Double minPrice, Integer minAmount) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String querry = "from Towar";
        querry += " WHERE nazwa LIKE '%'";
        if(name != null)
        	querry += "AND nazwa LIKE '%" + name + "%'";
        if(maxPrice != null)
        	querry += "AND cena <= " + maxPrice.toString();
        if(minPrice != null)
        	querry += "AND cena >= " + minPrice.toString();
        List<Towar> towars = session.createQuery(querry).list();
        
        session.getTransaction().commit();
        session.close();
        
        if(minAmount != null && minAmount > 0)
        	for(int i = 0; i < towars.size(); i++)
        		if(towars.get(i).getMagazyn() == null || towars.get(i).getMagazyn().getIlosc() < minAmount) {
        			towars.remove(i);
        			i--;
        		}

        return towars;
    }
	
	/** Inserts new move into moves table. */
	public static void insertTowar(Vat vat, String nazwa, double cena) throws Exception {
		

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
			try {
				Towar towar = new Towar(vat, nazwa, cena);
				Magazyn magazyn = new Magazyn(towar,0);
				session.save(towar);
				session.save(magazyn);
				transaction.commit();
			}
			catch(Exception exception) {
				transaction.rollback();
				throw exception;
			}
			finally {
				session.close();
			}
	}
	
	public static void main(String [] args) {
		List<Towar> towars = getTowars(null, null, null, null);
		
		for(Towar towar: towars)
			System.out.println(towar);
		System.out.println(towars.size());
	}
}
