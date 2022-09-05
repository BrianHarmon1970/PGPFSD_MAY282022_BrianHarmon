/*********************************
 *  File: MainController.java
 */
package com.ecommerce.controller;

import com.ecommerce.beans.CustomEventPublisher;
import com.ecommerce.dao.EProductDAO;
import com.ecommerce.dao.EUsersDAO;
import com.ecommerce.entity.EProduct;
import com.ecommerce.entity.EUsers;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.util.List;

import static java.lang.System.out;

@Controller
@SessionAttributes("UserBean")
public class MainController implements InitializingBean {
    //@ModelAttribute ("UserBean" )
    //EUsers UserBean() { return new EUsers() ; }

    @RequestMapping(value = "/customevent", method = RequestMethod.GET)
    public String customEvent(ModelMap map)
    {
        String confFile = "main-servlet.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(confFile);
        CustomEventPublisher cvp =
                (CustomEventPublisher) context.getBean("customEventPublisher");

        cvp.publish();
        cvp.publish();
        return "customEvent";
    }
    public void afterPropertiesSet() // InitializingBean interface implemntation
    {
        eUsersDAO.InitializeHibernate();
    }
    @PreDestroy
    public void Destroy()
    {
        eUsersDAO.CloseHibernate();
    }
    @Autowired
    EProductDAO eproductDAO;
    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public String listProducts(ModelMap map)
    {
        out.print("listProducts") ;
        List<EProduct> list= eproductDAO.getProducts();
        map.addAttribute("list",list);
        return "listProducts";
    }
    @Autowired
    EUsersDAO eUsersDAO ;
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String listUsers(ModelMap map)
    {
        out.print("listUsers") ;
        List<EUsers> list= eUsersDAO.getUsersData() ;
        map.addAttribute("list",list);
        return "listUsers";
    }

    @RequestMapping( value = "/findUser", method = RequestMethod.GET )
    public String findUser(@RequestParam("user_name") String user_name, Model m  )
    {
        EUsers e = eUsersDAO.findByUserName( user_name ) ;

        out.print( user_name );
        if( e != null )
        {
            m.addAttribute("UserBean", e ) ;
            return "UpdateUserData" ;
        }
        return "UserNotFound" ;
    }
    @RequestMapping( value = "userUpdate", method = RequestMethod.GET )
    public String updateUserTable(
                @RequestParam("first_name") String first_name,
                @RequestParam("last_name") String last_name,
                                   Model m )
    {
        EUsers e = (EUsers) m.asMap().get("UserBean") ;
        e.setLastName(last_name) ;
        e.setFirstName(first_name) ;
        eUsersDAO.UpdateUser( e ) ;

        return "confirmUserUpdate" ;
    }
    @RequestMapping( value = "home" )
    public String goHome()
    {
        return( "index" ) ;
    }
}

