package com.ecommerce;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder() ;
            StandardServiceRegistry standardRegistry ;
            //serviceRegistryBuilder.configure("/hibernate.cfg.xml") ;
            //serviceRegistryBuilder.
            //serviceRegistryBuilder.configure("com.ecommerce.EProduct.EProduct.hbm.xml") ;

            //Configuration configuration = new Configuration() ;
            //configuration.addResource( "EProduct.hbm.xml" ) ;
            //configuration.configure() ;

            standardRegistry = serviceRegistryBuilder.configure("/hibernate.cfg.xml").build();

            //StandardServiceRegistry standardRegistry = builder.build() ;

            MetadataSources metadataSources = new MetadataSources(standardRegistry) ;
            //metadataSources.addFile("\\WEB-INF\\com.ecommerce.EProduct.EProduct.hbm.xml" ) ;
            //File file = new File( "\\WEB-INF\\com.ecommerce.EProduct.EProduct.hbm.xml") ;
            //System.out.println( file.getAbsolutePath() + " " + file.getPath() ) ;
            //metadataSources.addFile( new File( "\\WEB-INF\\com.ecommerce.EProduct.EProduct.hbm.xml").getAbsolutePath() );
            //metadataSources.addFile( new File( "\\WEB-INF\\com.ecommerce.EProduct.EProduct.hbm.xml" );

            metadataSources.addResource("EProduct.hbm.xml" ) ;


            Metadata metaData = new MetadataSources(standardRegistry).buildMetadata() ;

            sessionFactory = metaData.getSessionFactoryBuilder().build();

        }
        catch(Throwable th) {
            System.out.println( "Exception caught: " + th.getClass().getName() ) ;
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

