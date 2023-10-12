// Q.1)Create Student and Course Entity to show one to Many and Many to one mapping.

package com.Swapnil.OneToMany2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil1 {
    private static SessionFactory sessionFactory = buildSessionFactoryNew();

    // A private method to build the SessionFactory
    private static SessionFactory buildSessionFactoryNew() {
        // Create a StandardServiceRegistry using the hibernate.cfg.xml configuration file
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml") // Load the Hibernate configuration from hibernate.cfg.xml
            .build();

        // Build the SessionFactory using the configuration
        SessionFactory sessionFactory = new Configuration().buildSessionFactory(standardRegistry);

        return sessionFactory;
    }

    // Get the SessionFactory instance
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Shutdown method to close caches and connection pools
    public static void shutdown() {
        getSessionFactory().close();
    }
}
