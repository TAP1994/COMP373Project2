package com.fms.dal;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by Tom on 4/4/2016.
 */
public class HibernatePGSQLHelper {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("*************** Session Factory instantiated ..................");
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
