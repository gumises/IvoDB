package newdatabase.connector;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import newdatabase.HibernateUtil;
import newdatabase.Magazyn;
import newdatabase.Towar;
import newdatabase.Vat;

public class DBConnector {

	/** Returns Vat object by id. */
	public static void dynamicQuery(String query) throws Exception {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
		try {
			List<Object> results = session.createSQLQuery(query).list();
			transaction.commit();
			for(Object element: results)
				System.out.println(element);
		}
		catch (Exception exception) {
			transaction.rollback();
			throw exception;
		}
		finally {
	        session.close();
		}
    }
	
	public static void main(String [] args) {
		try {
			dynamicQuery("SELECT * FROM towar");
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
}
