package com.harmonengineering;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.testng.internal.Utils.copyFile;

public class SeleniumAutomation
{
    //public static final String htmlLocation = "file:"+System.getProperty("user.dir")+"/src/main/resources/index.html";
    public static final String htmlLocation = "http://localhost:4200/";
    public static final String screenShotDir = System.getProperty("user.dir")+"/src/main/resources/";
    private static WebElement AppNavbarSignin ;
    private static WebElement AppNavbarSignup ;
    private static WebElement AppNavbarPortfolio ;
    private static WebDriver driver ;

    private static WebElement MainNavbarLogout ;
    private static WebElement MainNavbarContact ;
    private static WebElement MainNavbarInvoice ;
    private static WebElement MainNavbarOrders ;
    private static WebElement MainNavbarProducts ;
    private static WebElement MainNavbarPortfolio ;

    public static void main( String[] args )
    {
        //System.setProperty("webdriver.chrome.driver",
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver",
        //        "E:\\HarmonEngineering\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        try {
            driver.get(htmlLocation);
            String url = driver.getCurrentUrl();
            System.out.println(url);
            System.out.println(driver.getTitle());
            try {
                doInitialSetup();
                doScript();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } catch( Exception e )
        {
            System.out.println( "Unable to connect to Application in browser or driver failure. " ) ;
            System.out.println( "Error: " + e.getMessage()) ;
        }

    }

    // after logout or on initial loading, setup the Element variables to reflect the contextual navbar links
    // ( context, logged out(anonymous), viewing initial resources - including sign-in and sign-up form pages.
    public static void doInitialSetup()
    {
        System.out.println("Element found: " + driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[1]")));
        System.out.println("Element found: " + driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[2]")));
        System.out.println("Element found: " + driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[3]")));

        AppNavbarPortfolio = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[1]"));
        AppNavbarSignin = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[2]"));
        AppNavbarSignup = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[3]"));

    }

    // after login, setup the Element variables to reflect the contextual navbar links ( context, logged in, viewing
    // main resources )
    public static void doMainSetup()
    {
//        try {
                // Initially, after login, the application lands on a duplicated main-navbar in the app-main component
                // this was not the intended behaviour for the application design but can be worked around by using
                // this initial nav-bar to navigate to a child page and its appropriately associated main-navbar so
                // that the siblings (or self) can be located for subsequent navigations - here using the sub-portofolia
                // page as the landing page for the secondary nav-bar
                WebElement appMainMainNavbarPortfolio = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/app-main/main-navbar/nav/span[1]")) ;
                appMainMainNavbarPortfolio.click() ;
  //          } catch ( NoSuchElementException e ) {}

        MainNavbarLogout = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/nav/span[6]")) ;
        MainNavbarContact = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/nav/span[5]")) ;
        MainNavbarInvoice = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/nav/span[4]")) ;
        MainNavbarOrders = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/nav/span[3]")) ;
        MainNavbarProducts = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/nav/span[2]")) ;
        MainNavbarPortfolio = driver.findElement(By.xpath("/html/body/app-root/div[2]/main-navbar/nav/span[1]")) ;
    }
    public static void doScript()
    {
        //AppNavbarPortfolio.click() ;

        TakeScreenShot("0001.png") ;
        Login( "user","pass123") ; TakeScreenShot("0003.png") ;
        Logout() ;       TakeScreenShot("0004.png") ;

        // clicking around before attempting to sign-in/sign-up ( sane check )
        AppNavbarSignup.click() ;        TakeScreenShot("0005.png") ;
        AppNavbarPortfolio.click() ;     TakeScreenShot("0001.png") ;
        AppNavbarSignin.click() ; // seems to be non-disruptive... so good.
        TakeScreenShot("0006.png") ;

        Register( "user2", "munich") ;
        doMainPortfolio();        TakeScreenShot("0007.png") ;
        doMainContact();        TakeScreenShot("0008.png") ;
        doMainOrders();        TakeScreenShot("0009.png") ;
        doMainProducts();        TakeScreenShot("0010.png") ;
        Logout();        TakeScreenShot("0011.png") ;

        Login("user","pass123") ;         TakeScreenShot("0012.png") ;;
        doMainInvoice() ;                               TakeScreenShot("0013.png") ;
    }


    public static void doMainPortfolio() { MainNavbarPortfolio.click() ;}
    public static void doMainProducts() {  MainNavbarProducts.click() ; }
    public static void doMainOrders() {  MainNavbarOrders.click() ; }
    public static void doMainInvoice() { MainNavbarInvoice.click() ;}
    public static void doMainContact() { MainNavbarContact.click() ;}
    public static void Logout() {  MainNavbarLogout.click() ; doInitialSetup();}
    public static void TakeScreenShot( String strFileName )
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File scr = ts.getScreenshotAs(OutputType.FILE);
        String fileName = screenShotDir + strFileName ;
        System.out.println( fileName ) ;
        copyFile(scr, new File(fileName));

    }
    public static void Login( String loginid, String password )
    {
        try {
            //AppNavbarSignin = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[2]"));
            AppNavbarSignin.click();
            WebElement signinForm = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/app-security-signin/div[2]/form")) ;
            WebElement nameElement , passwordElement ;
            System.out.println("Element found: " + driver.findElement(By.id("name")));
            System.out.println("Element found: " + driver.findElement(By.id("password")));
            System.out.println("Element found: " + driver.findElement(By.id("password")));
            nameElement = driver.findElement(By.id("name")) ;
            passwordElement = driver.findElement(By.id("password")) ;
            nameElement.sendKeys(loginid);
            passwordElement.sendKeys(password );
            signinForm.submit();
            doMainSetup();
        } catch( NoSuchElementException e ) { e.printStackTrace(); }
    }
    public static void Register( String loginid, String password )
    {
        try {
            //AppNavbarSignup = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/div[1]/span[3]"));
            AppNavbarSignup.click();
            WebElement signupForm = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-app-navbar/app-security-signup/div[2]/form")) ;
            WebElement nameElement , passwordElement, passwordConfirmElement ;

            System.out.println("Element found: " + driver.findElement(By.id("name")));
            System.out.println("Element found: " + driver.findElement(By.id("password")));
            System.out.println("Element found: " + driver.findElement(By.id("password_confirmation")));

            nameElement = driver.findElement(By.id("name")) ;
            passwordElement = driver.findElement(By.id("password")) ;
            passwordConfirmElement = driver.findElement(By.id("password_confirmation"));
            nameElement.sendKeys(loginid);
            passwordElement.sendKeys(password );
            passwordConfirmElement.sendKeys(password );
            signupForm.submit();
            doMainSetup() ;
        } catch( NoSuchElementException e ) { e.printStackTrace(); }
    }
}

