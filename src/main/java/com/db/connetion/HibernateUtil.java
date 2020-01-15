package com.db.connetion;


import com.model.Doctor;
import com.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static  SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure(new File("src/resources/hibernate.cfg.xml"))
                    .addAnnotatedClass(Doctor.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory(); //add package if used.

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
