package com.ecommerce.controller;

import com.ecommerce.beans.CustomEventPublisher;
import com.ecommerce.dao.EProductDAO;
import com.ecommerce.entity.EProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static java.lang.System.out;


@Controller
public class MainController {



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

}

