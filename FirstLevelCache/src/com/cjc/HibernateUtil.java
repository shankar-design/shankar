package com.cjc;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;


public class HibernateUtil {
  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;
  
  public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
		try {
        StandardServiceRegistryBuilder registryBuilder=
        		new StandardServiceRegistryBuilder();
        Map<String, Object> settings = new HashMap<>();
        settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/flc");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "root");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "update");

      // settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
        
        //Specify cache region factory class
      // settings.put(Environment.CACHE_REGION_FACTORY,
        //      "org.hibernate.cache.ehcache.EhCacheRegionFactory");
         
      
        registryBuilder.applySettings(settings);

        registry = registryBuilder.build();

        MetadataSources sources = new MetadataSources(registry)
            .addAnnotatedClass(Student.class);

           // .addAnnotatedClass(UserDetail.class)
           // ;

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
      } catch (Exception e) {
    	  e.printStackTrace();
        System.out.println("SessionFactory creation failed");
       // e.getMessage(); // bcz of geting datil msg not create sf
        
        if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
      }
    }
    return sessionFactory;
  }

  public static void shutdown() {
    if (registry != null) {
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }
}
