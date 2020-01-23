package newdatabase.connector;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import newdatabase.Faktura;
import newdatabase.HibernateUtil;
import newdatabase.Kategoria;
import newdatabase.KategoriaId;
import newdatabase.Magazyn;
import newdatabase.Nabywca;
import newdatabase.Towar;
import newdatabase.Vat;
import newgui.panels.addfacture.TowarData;

public class FactureConnector {

	/** Returns Vat object by id. */
	/*
	public static Vat getVat(int id) {
		 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Vat vat = (Vat) session.get(Vat.class, id);
        
        session.getTransaction().commit();
        session.close();
        return vat;
    }
    */
	
	public static void insertFacture(Nabywca nabywca, String numer, List<TowarData> towarsData) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
        	Faktura faktura = new Faktura(nabywca, new Date(), numer);
        	session.save(faktura);
        	for(TowarData towarData: towarsData) {
        		KategoriaId kategoriaId = new KategoriaId(faktura.getId(), towarData.getId(), towarData.getAmount());
        		
        		Towar towar = (Towar) session.get(Towar.class, towarData.getId());
        		Magazyn magazyn = towar.getMagazyn();
        		Kategoria kategoria = new Kategoria(kategoriaId, faktura, towar);
        		magazyn.setIlosc(magazyn.getIlosc() - towarData.getAmount());
        		
        		session.save(magazyn);
        		session.save(towar);
        		session.save(kategoria);
        	}
        	transaction.commit();
        }
        catch(Exception exception) {
        	transaction.rollback();
        	exception.printStackTrace();
        }
        finally {
        	session.close();
        }
	}
}
