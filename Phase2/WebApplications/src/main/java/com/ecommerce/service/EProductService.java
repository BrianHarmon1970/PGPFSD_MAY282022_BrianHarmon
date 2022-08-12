package com.ecommerce.service;

import com.ecommerce.EProduct;
import com.ecommerce.dao.EProductDAO;
import com.ecommerce.entity.EProductEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class EProductService
{
    public Object getAllProducts()
    {

        EProductEntity e = new EProductEntity() ;
        EProductDAO dao = new EProductDAO() ;


        e.setDateAdded( new Date()) ;
        e.setID( 101010101 ) ;
        e.setName( "Null Product" ) ;
        e.setPrice( new BigDecimal("101010101.101")) ;
        ArrayList<EProductEntity> l = new ArrayList<>() ;
        l.add( e ) ;

        //return dao.getAllProducts() ;
        return l ;
    }
}
