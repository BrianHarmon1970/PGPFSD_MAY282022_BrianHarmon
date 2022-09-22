package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class TestUtility {
   
	List<String> allUsers = new ArrayList<>();
   
	public List<String> getAllUsers() {
	   return allUsers;
    }
   
	public void addUser(String user) {
	   allUsers.add(user);
    }
   
	public void deleteUser(String user) {
	   allUsers.remove(user);
    }
   
	public static void evenNumverTest() {
	   int num = 30;
	   assertTrue(num % 2 == 0, "Result will be true");
    }
   
	public static void oddNumberTest() {
	   int num = 21;
	   assertTrue(num % 2 == 1, "Result will be true");
    }   
   
	public long multiplyNumbers(int num1, int num2) {
	  return num1 * num2;
    }
   
	public long addNumbers(int num1, int num2) {
	  return num1 + num2;
    }    
}
