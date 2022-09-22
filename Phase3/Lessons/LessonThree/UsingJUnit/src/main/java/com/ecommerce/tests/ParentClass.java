package com.ecommerce.tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class ParentClass

{
    public int factorial( int number )
    {
        if(number == 0 || number == 1){ // base for calculation. If the number received is 0 or 1 we return 1. Factorial of 0 or 1 is 1.

            return 1;
        }
        return number * (factorial(number-1)); // 2 – recursive call.
    }
public int Sum( int n )
{
    int sum = 0 ;
    for ( int  i = 0 ; i <= n ; ++i )
        sum+= i ;
    return sum ;
}

    @BeforeAll
    public static void beforeAll() { System.out.println("Before All") ; }

    @AfterAll
    public static void afterAll() { System.out.println("After All") ; }


    //@Test
    @BeforeEach
    public void beforeEach() { System.out.println("Before Each") ; }



    @Test
    @DisplayName("FactorialTest")
    void FactorialTest(  )
    {
        System.out.println("FactorialTest") ;
        assertEquals( factorial(5), 120) ;
    }
            ;
    @Test
    @DisplayName("SumTest")
    void SumTest(  )
    {
        System.out.println("SumTest") ;
        assertEquals( Sum(20), 220) ;
    }

    @Test
    @DisplayName("AssertTest")
    public void AssertTest()
    {
        System.out.println( "Assertion True/False Test" ) ;
        assertFalse( 5>6 ) ;
        assertTrue( 4>5 ) ;

    }
    //@Test
    @AfterEach
    public void afterEach() { System.out.println("After Each") ; }



}


