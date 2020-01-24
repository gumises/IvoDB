package newdatabase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class HibernateUtil {

    private static final Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    static {
        configuration.configure();
        reset();

    }

    public static int createNewSession(String password, String login) {
        int access = 2;
        configuration.setProperty("hibernate.connection.username", login);
        configuration.setProperty("hibernate.connection.password", password);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            List list = sessionFactory.openSession().createSQLQuery("show grants").list();
            if (list.get(0).toString().startsWith("GRANT ALL PRIVILEGES")) {
                access = 0;
            }
            else if (list.size()>1&&list.get(1).toString().startsWith("GRANT SELECT, INSERT")) {
                access = 1;
            }
        } catch (
                Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
        return access;
    }

    public static void reset() {

        configuration.setProperty("hibernate.connection.username", "guest");
        configuration.setProperty("hibernate.connection.password", "111");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (
                Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}

