package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
 
@DisplayName("JUnit 5 Dependency Injection Example")
//@RunWith(JUnitPlatform.class)
public class DependencyInjection {

        DependencyInjection(TestInfo testInfo) {
        assertEquals("JUnit 5 Dependency Injection Example", testInfo.getDisplayName());  // it matches the @DisplayName of this class
        }

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());  // it matches the @DisplayName of this method
        assertTrue(testInfo.getTags().contains("my-tag"));  // it matches the @Tag of this method
    }

    @Test
    void test2() {
    }

}

