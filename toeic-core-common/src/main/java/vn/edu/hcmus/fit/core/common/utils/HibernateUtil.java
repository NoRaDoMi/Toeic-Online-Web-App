package vn.edu.hcmus.fit.core.common.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    // Phương thức tạo SessionFactory từ hibernate.cfg.xml trong Hibernate 5
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                // Tạo registry
                registry = new StandardServiceRegistryBuilder()
                        .configure().build();

                // Tạo MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Tạo Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Tạo SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if(registry != null)
                    StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return sessionFactory;
    }
}
