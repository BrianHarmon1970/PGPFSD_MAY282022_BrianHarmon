/****************************
 *  HibernateSession.java
 */
package com.harmonengineering;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.mapping.PersistentClass;

import java.util.Iterator;
import java.util.Properties;

public class HibernateSession
{
    private Configuration config ;
    private MetadataSource metaDataSource ;
    private Session m_Session ;
    private SessionFactory sessionFactory ;

    Session getSession() { return m_Session ; }
    public Session createSession()
    {
        config = new Configuration().configure("hibernate.cfg.xml") ;

        //ShowConfiguration( config );
        sessionFactory = config.buildSessionFactory() ;
        m_Session = sessionFactory.openSession() ;
        return m_Session ;
    }
    public void closeHibernate()
    {
        sessionFactory.close() ;
    }
    void ShowConfiguration( Configuration config )
    {
        Iterator<PersistentClass> iterator = config.getClassMappings() ;
        PersistentClass pc ;
        while ( iterator.hasNext() )
        {
            pc = iterator.next() ;
            System.out.println( "Configured Entity: " + pc.getEntityName()) ;
        }
        Properties p = config.getProperties() ;
        System.out.println("<Configured Properties>" ) ;
        p.list( System.out ) ;
    }
}
