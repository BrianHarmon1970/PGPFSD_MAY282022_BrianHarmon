/*********************************
 *  File: EUsersDAO.java
 */

package com.ecommerce.dao;

import com.ecommerce.entity.EProduct;
import com.ecommerce.entity.EUsers;
import com.harmonengineering.HibernateSession;
import com.harmonengineering.UsersData;
import org.hibernate.Session;

import java.util.List;

public class EUsersDAO
{
    private HibernateSession    m_Hibernate ;
    private UsersData           m_UsersData ;
    public void InitializeHibernate()
    {
        m_Hibernate = new HibernateSession() ;
        m_UsersData = new UsersData() ;
        Session session = m_Hibernate.createSession() ;
        m_UsersData.setSession( session ) ;

    }
    public void CloseHibernate()
    {
        m_UsersData.getSession().close() ;
        m_Hibernate.closeHibernate() ;
    }
    public List<EUsers> getUsersData()
    {

        //InitializeHibernate() ;
        List<EUsers> l = m_UsersData.ListEntities() ;
        //CloseHibernate() ;
        return l ;
    }
    public EUsers findByUserName( String uName ) { return m_UsersData.findByUserName( uName ) ; }
    public void UpdateUser( EUsers user ) { m_UsersData.UpdateUser( user ) ; }

}
