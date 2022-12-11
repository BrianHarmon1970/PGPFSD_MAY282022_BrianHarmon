package com.harmonengineering.service;

import com.harmonengineering.beans.ConfiguredPortNumberBean;
import com.harmonengineering.entity.OrderItem;
import com.harmonengineering.entity.User;
import com.harmonengineering.entity.UserOrder;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserService
{


    static private int serverPort  ;

    @Autowired
    //private ServerProperties serverProperties;

    //public static final String userResourceUrl = "http://localhost:"+serverPort+"/user" ;
    public static  String userResourceUrl = "/user" ;
    public static ConfiguredPortNumberBean portNumberBean ;
    static final RestTemplate restTemplate = new RestTemplate() ;


    public UserService( ConfiguredPortNumberBean portBean )
    {
        this.portNumberBean = portBean ;
        serverPort = portBean.serverPort ;
        serverPort = 8080 ;
    }
    public String hostName()
    {

       // return "http://localhost:"+System.getProperty( "${server.port}","8787" ) ; }
        return "http://localhost:"+ serverPort ; }
//    public UserService()
//    {
//        //System.out.println( "name:" + hostName() );
//        userResourceUrl = hostName() + "/user" ;
//    }
    public List<User> getUserList( )
    {
        System.out.println( userResourceUrl );
        System.out.println( hostName() );

        ResponseEntity<User[]> userList =
                restTemplate.getForEntity(hostName()+userResourceUrl + "/listall",
                        User[].class);

        return Arrays.asList( userList.getBody() ) ;
    }
    public User getUserById(Long id)
    {
        ResponseEntity<User> product = restTemplate.getForEntity( userResourceUrl + "/" + id ,User.class  ) ;
        return product.getBody() ;
    }
    public void updateUser( User u )
    {
        HttpEntity<User> req = new HttpEntity<>( u );
        restTemplate.exchange( userResourceUrl + "/update/" + u.getId(), HttpMethod.PUT, req, User.class ) ;
    }
    public List<User> getSearchResultList( User criteriaP )
    {
        StringBuilder sb = new StringBuilder() ;
        sb.append( userResourceUrl ).append("/search") ;
        sb.append( "/").append( criteriaP.getId() ) ;
        sb.append( "/").append( criteriaP.getUserName() ) ;
        sb.append("/").append( criteriaP.getFirstName()) ;
        sb.append("/").append( criteriaP.getLastName()) ;
        System.out.println("StringBuilder -> " + sb.toString()) ;

        ResponseEntity<User[]> userList =
                restTemplate.getForEntity( sb.toString(), User[].class );
        return Arrays.asList(Objects.requireNonNull(userList.getBody())) ;
    }
    public List<UserOrder> getOrders()
    {
        ResponseEntity<UserOrder[]> orders =
                restTemplate.getForEntity( userResourceUrl + "/orders" ,
                    UserOrder[].class ) ;
        return Arrays.asList( orders.getBody() ) ;
    }
    public UserOrder saveUserOrder( UserOrder order )
    {
        HttpEntity<UserOrder> req = new HttpEntity<>( order  );
        return restTemplate.postForObject(userResourceUrl + "/orders/add", req, UserOrder.class);
    }
    public OrderItem saveOrderItem( OrderItem item )
    {
        HttpEntity<OrderItem> req = new HttpEntity<>( item ) ;
        return restTemplate.postForObject( userResourceUrl + "/orderitems/add", req, OrderItem.class) ;
    }
    public List<OrderItem> getOrderItemsByOrderId( Long orderId )
    {
        ResponseEntity<OrderItem[]> items =
                restTemplate.getForEntity( userResourceUrl + "/orderitems/" + orderId ,
                        OrderItem[].class ) ;
        return Arrays.asList( items.getBody() ) ;
    }
}
