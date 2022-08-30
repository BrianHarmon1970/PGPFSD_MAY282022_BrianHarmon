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

/*
public class EmployeeHibernateDemo
{
    static Configuration config ;
    MetadataSource metaDataSource ;
    static SessionFactory sessionFactory ;

    public static void main( String[] args ) {
        Session session = createSession();
        System.out.println("Created session, connected: " + (session.isConnected()));

        System.out.println( "Listing Employee certifications" ) ;
        ListCertificates( session ) ;
        System.out.println( "Listing employee salaries" ) ;
        ListEmployeeSalaries( session ) ;

        AddEmployee( session )  ;

        session.close() ;
        System.out.println( "Session closed." ) ;
    }
    static void AddEmployee( Session session )
    {
        BigDecimal bigsalary = new BigDecimal("100000.00") ;
        EmployeeSalary newEmployeeSalary = new EmployeeSalary() ;
        newEmployeeSalary.setFirstName( "Johnny" ) ;
        newEmployeeSalary.setLastName( "Biggs" ) ;
        newEmployeeSalary.setSalary( bigsalary ) ;

        session.getTransaction().begin();
        session.persist( newEmployeeSalary );
        session.save( newEmployeeSalary ) ;
        session.getTransaction().commit();
    }
    static void ListEmployeeSalaries( Session session )
    {
        List<EmployeeSalary> l = session.createQuery(
                "from com.harmonengineering.EmployeeSalary").list();

        for (EmployeeSalary salary : l) {
            System.out.println( salary.getFirstName() + "\t"
                    + salary.getLastName() + "\t"
                    + salary.getSalary() ) ;
        }
    }
    static void ListCertificates( Session session )
    {
        List<EmployeeCertificate> l = session.createQuery(
                "from com.harmonengineering.EmployeeCertificate").list();

        for (EmployeeCertificate c : l) {
            System.out.println(c.getEmployeeID() + "\t" + c.getDescription());
        }
    }
    static Session createSession()
    {
        config = new Configuration().configure("hibernate.cfg.xml") ;

        ShowConfiguration( config );
        sessionFactory = config.buildSessionFactory() ;
        return sessionFactory.openSession() ;
    }

    static void ShowConfiguration( Configuration config )
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
*/