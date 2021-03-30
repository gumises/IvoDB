package newdatabase.connector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import newdatabase.HibernateUtil;
import newdatabase.Vat;

public class VatConnector {

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
	
}
