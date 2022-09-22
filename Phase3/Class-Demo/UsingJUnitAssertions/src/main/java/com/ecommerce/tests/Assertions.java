package com.ecommerce.tests;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;

@DisplayName("JUnit 5 Assertions Example")
//@RunWith(JUnitPlatform.class)
public class Assertions {

        @Test
        @DisplayName("assert Examples")
        public void assertTests() {
        	System.out.println(" this is my test method");
                String str = null;
                String str1 = null;
                String str2 = "some value";
                
                String[] a1 = { "A", "B" };
                String[] a2 = { "B", "A" };
                
                assertTrue(4 > 0);  //pass
                assertFalse(5 < 1);  //pass
                assertNull(str);    //pass
                assertNotNull(str2);   //pass
                
                assertSame(str, str1);   //pass
                assertNotSame(str, str2);   //pass
                
                assertEquals(5, 5);   //pass
                assertNotEquals(5, 6);   //pass
                
                assertArrayEquals(a1, a2); 
                
                assertThrows(RuntimeException.class, () -> {
                        throw new RuntimeException();
                });
        }
        
        @BeforeEach
        public void beforeAssert() {
        	System.out.println(" this is my before test assert method");
        }
        
        @AfterEach
        public void afterAssert() {
        	System.out.println(" this is my after test assert method");
        }
        
        
}

