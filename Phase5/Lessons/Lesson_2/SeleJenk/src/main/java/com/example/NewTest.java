package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class NewTest {
    static final String driverDir = System.getProperty("user.dir") + "/src/main/Resources/";
    private WebDriver driver;
    SoftAssert soft=new SoftAssert();
    @Test
    public void testEasy() {
        System.setProperty("webdriver.chrome.driver", driverDir + "chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        String title = driver.getTitle();
        soft.assertEquals("FB Login",title);
    }
    @BeforeTest
    public void beforeTest() {
        //driver = new FirefoxDriver();
        driver =  new ChromeDriver() ;
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

