package com.service;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testOperationsTest {

  @Test
  public void addTest() {
    //throw new RuntimeException("Test not implemented");
	  testOperations op = new testOperations() ;
	  int result = op.add( 100, 200 ) ;
	  assertEquals( result, 300) ;
  }
  @Test
  public void subTest() {
    //throw new RuntimeException("Test not implemented");
	  testOperations op = new testOperations() ;
	  int result = op.sub( 100, 200 ) ;
	  assertEquals( result, -100) ;
  }
  @Test
  public void mulTest() {
    //throw new RuntimeException("Test not implemented");
	  testOperations op = new testOperations() ;
	  int result = op.mul( 100, 200 ) ;
	  assertEquals( result, 20000) ;
  }
  @Test
  public void divTest() {
    //throw new RuntimeException("Test not implemented");
	  testOperations op = new testOperations() ;
	  double result = op.div( 100, 200 ) ;
	  assertEquals( result, 0.5) ;
  }
  
}
