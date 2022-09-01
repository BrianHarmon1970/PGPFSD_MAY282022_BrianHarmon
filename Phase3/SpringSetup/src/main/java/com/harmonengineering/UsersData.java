/****************************
 *  UsersData.java
 */
package com.harmonengineering;
import com.ecommerce.entity.EUsers ;
import org.hibernate.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class UsersData
{
    private Session m_HibernateSession;
    private Transaction m_Transaction ;

    public void setSession( Session session ){ m_HibernateSession = session ; }
    public Session getSession( ) { return m_HibernateSession; }
    public List<EUsers> ListEntities()
    {
        //ArrayList<EProduct> e = new ArrayList<EProduct>() ;
        List l = (m_HibernateSession.createQuery(
                "from EUsers").list());

        return l ;
    }

    public void AddProduct( EUsers newEntity )
    {
        m_HibernateSession.getTransaction().begin();
        m_HibernateSession.persist( newEntity );
        m_HibernateSession.save( newEntity ) ;
        m_HibernateSession.getTransaction().commit();
    }
    public EUsers findByUserName( String userName )
    {
        EUsers e = null ;
        SQLQuery sQL = m_HibernateSession.createSQLQuery(" select user_name, first_name, last_name from eusers where user_name=?" ) ;
        Query hQL = m_HibernateSession.createQuery("from EUsers E where E.userName = :userName") ;
        hQL.setParameter( "userName" , userName ) ;
        List result = hQL.list() ;
        if( result.size() > 0 )
            return (EUsers) result.get(0) ;
        else return null ;
    }
    public void UpdateUser( EUsers user )
    {
        out.println( "ID is " + user.getID()) ;
        out.println( "user_name " + user.getUserName()) ;
        out.println( "first_name " + user.getFirstName()) ;
        out.println( "last_name " + user.getLastName()) ;

        String queryText = "Update EUsers E set E.firstName=:fName, E.lastName=:lName where ID = :Identity " ;
        //SQLQuery sQL =
        //        m_HibernateSession.createSQLQuery(" update eusers set first_name= :fName, last_name= :lName where ID = :Identity") ;

        Query updateUserQuery = m_HibernateSession.createQuery( queryText ) ;

        updateUserQuery.setParameter( "fName", user.getFirstName()) ;
        updateUserQuery.setParameter( "lName", user.getLastName()) ;
        updateUserQuery.setLong("Identity", user.getID());

        //sQL.setParameter( "fName", user.getFirstName()) ;
        //sQL.setParameter( "lName", user.getLastName()) ;
        //sQL.setLong("Identity", user.getID());


        m_Transaction = m_HibernateSession.beginTransaction() ;
        int status = updateUserQuery.executeUpdate() ;
//        int status = sQL.executeUpdate() ;
        m_Transaction.commit() ;
        out.print( "QueryExecute status: " + status ) ;

    }
}
