package com.harmonengineering.service;

import com.harmonengineering.entity.OrderItem;
import com.harmonengineering.entity.User;
import com.harmonengineering.entity.UserOrder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserService
{
    public static final String userResourceUrl = "http://localhost:8080/user" ;
    static final RestTemplate restTemplate = new RestTemplate() ;

    public List<User> getUserList( )
    {
        ResponseEntity<User[]> userList =
                restTemplate.getForEntity(userResourceUrl + "/listall",
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
