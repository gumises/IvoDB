package newdatabase.connector;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import newdatabase.Adres;
import newdatabase.HibernateUtil;
import newdatabase.Nabywca;
import newdatabase.Towar;

public class ClientConnector {

	/** Inserts new purchaser and his address. */
	public static void insertClient(String name, String phone, String nip, String city, String street, String house, String post) throws Exception {
		
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
			try {
				Nabywca nabywca = new Nabywca(name, phone, nip);
				session.save(nabywca);
				Adres adres = new Adres(nabywca, post, city, street, house);
				session.save(adres);
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
	
	/** Returns list of Towars. */
	public static List<Nabywca> getClients(String name, String phone, String nip) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String querry = "from Nabywca";
        querry += " WHERE nazwa LIKE '%'";
        if(name != null)
        	querry += "AND nazwa LIKE '%" + name + "%'";
        if(phone != null)
        	querry += "AND telefon LIKE '%" + phone + "%'";
        if(nip != null)
        	querry += "AND nip LIKE '%" + nip + "%'";
        List<Nabywca> nabywcy = session.createQuery(querry).list();
        
        session.getTransaction().commit();
        session.close();
        
        return nabywcy;
    }
	
	/** Returns Nabywca object by name. */
	public static Nabywca getClient(String name) {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        List<Nabywca> clients = session.createQuery("from Nabywca WHERE nazwa='"+name+"'").list();
        
        session.getTransaction().commit();
        session.close();
        
        return clients.get(0);
    }
	
	public static void main(String [] args) {
		//List<Nabywca> clients = getClients(null, null, null);
		
		//for(Nabywca client: clients)
		//	System.out.println(client);
		//System.out.println(clients.size());
		
		System.out.println(getClient("weqweq"));
	}
	
}
