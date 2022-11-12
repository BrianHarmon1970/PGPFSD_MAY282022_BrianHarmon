package com.service;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;



public class TestHookMethods {
  @Test(dataProvider = "dp")
 //@Ignore
  public void f(Integer n, String s) {
	  System.out.println( "Testing method 1" ) ;
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println( "Before Test" ) ;
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println( "AFter Test" ) ;
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println( "Before Class Test - only once rquires at least one @Test" ) ;
  }
  	

  @AfterClass
  public void afterClass() {
	  System.out.println( "AFter Class Test - only once rquires at least one @Test" ) ;
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println( "Before Test - only once " ) ;
  }

  @AfterTest
  public void afterTest() {
	  System.out.println( "After Test - only once " ) ;
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println( "Before Test Suite" ) ;
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println( "AFter Test Suite" ) ;
  }

}
