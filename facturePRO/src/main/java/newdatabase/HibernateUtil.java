package newdatabase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
 public class HibernateUtil {

    private static final Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    static {
        configuration.configure();
       reset();

    }

    public static void createNewSession(String password, String login) {

        configuration.setProperty("hibernate.connection.username", login);
        configuration.setProperty("hibernate.connection.password", password);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (
                Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }

    }
     public static void reset(){

         configuration.setProperty("hibernate.connection.username", "new");
         configuration.setProperty("hibernate.connection.password", "pass");
         serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
         try {
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         } catch (
                 Exception e) {
             System.err.println("Initial SessionFactory creation failed." + e);
             throw new ExceptionInInitializerError(e);
         }}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

