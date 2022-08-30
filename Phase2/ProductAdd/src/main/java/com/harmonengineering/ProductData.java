/****************************
 *  ProductData.java
 */
package com.harmonengineering;
import com.ecommerce.EProduct ;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductData
{
    Session m_HibernateSession  ;
    public void setSession( Session session ){ m_HibernateSession = session ; }
    public List<EProduct> ListProducts()
    {
        //ArrayList<EProduct> e = new ArrayList<EProduct>() ;
        List l = (m_HibernateSession.createQuery(
                "from com.ecommerce.EProduct").list());

        return l ;
    }
    public void AddProduct( String productName, String productPrice )
    {
        EProduct newProduct = new EProduct() ;
        newProduct.setName( productName ) ;
        newProduct.setPrice(BigDecimal.valueOf(Double.parseDouble(productPrice))) ;
        AddProduct( newProduct ) ;
    }
    public void AddProduct( EProduct newProduct )
    {
        m_HibernateSession.getTransaction().begin();
        m_HibernateSession.persist( newProduct );
        m_HibernateSession.save( newProduct ) ;
        m_HibernateSession.getTransaction().commit();
    }
}
