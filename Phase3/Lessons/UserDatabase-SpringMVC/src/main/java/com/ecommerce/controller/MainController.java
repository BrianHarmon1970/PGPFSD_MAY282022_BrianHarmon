package com.ecommerce.controller;

import com.ecommerce.DAO.EUserDAO;
import com.ecommerce.Entity.EUser;
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
public class MainController
{
    @Autowired
    EUserDAO eUserDAO;
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String listUsers(ModelMap map)
    {
        List<EUser> list= eUserDAO.getProducts();
        map.addAttribute("list",list);
        return "listUsers";
    }

}

