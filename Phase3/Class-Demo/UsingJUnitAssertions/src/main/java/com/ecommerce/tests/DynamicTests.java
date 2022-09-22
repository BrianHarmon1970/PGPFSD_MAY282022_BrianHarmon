package com.ecommerce.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.DynamicTest.*;
import org.junit.jupiter.api.TestFactory;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
@DisplayName("JUnit 5 Dynamic Tests Example")
//@RunWith(JUnitPlatform.class)
public class DynamicTests {

	    //-------------- Dynamic Test with Collection-------------//
        @TestFactory
        @DisplayName("Dynamic Test with Collection")
        Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(
            dynamicTest("simple dynamic test", () -> assertTrue(true)),
            dynamicTest("My Executable Class", new MyExecutable()),
            //dynamicTest("Exception Executable", () -> {throw new Exception("Exception Example");}),     // this is failing
            dynamicTest("simple dynamic test-2", () -> assertTrue(true))
        );
    }
        
        //-------------- Dynamic Test with Stream-------------//
        @TestFactory
        @DisplayName("Dynamic Test with Stream")
        Stream<DynamicTest> userAvailabilityDynamicTestWithStream() {
        	
        	TestUtility utility = new TestUtility();
        	
        	return Stream.of("Krishna", "Arjun", "Bheem")
        		.map(user -> DynamicTest.dynamicTest("User Test: " + user, () -> { 
        			assertNotNull(utility.getAllUsers());
        			utility.addUser(user);
        			assertTrue(utility.getAllUsers().contains(user), "User will exist");
        			utility.deleteUser(user);
        			assertFalse(utility.getAllUsers().contains(user), "User will not exist");            	
        		 }));
        } 
}

class MyExecutable implements Executable {

        @Override
        public void execute() throws Throwable {
                System.out.println("Hello World!");
        }
}



