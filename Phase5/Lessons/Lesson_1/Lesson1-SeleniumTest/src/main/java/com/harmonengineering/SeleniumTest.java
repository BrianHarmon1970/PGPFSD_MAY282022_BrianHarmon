package com.harmonengineering;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class SeleniumTest
{
    public static final String htmlLocation = "file:"+System.getProperty("user.dir")+"/src/main/resources/index.html";

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver",
        WebDriver driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver",
        //        "E:\\HarmonEngineering\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        driver.get(htmlLocation);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        System.out.println(driver.getTitle());

        System.out.println("Step 1.2.1 Using id as a Locator");
        System.out.println("Element found: " +
                driver.findElement(By.id("Email")));

        System.out.println("Step 1.2.2 Using class name as a Locator");
        //●	Finding  Web element using Locator ClassName
        //        a.	Syntax : class = Class Name of the element
        //        b.	Example : driver.findElement(By.class(“classname”));
        System.out.println("Element found: " + driver.findElement(By.className("classname")));


        System.out.println("Step 1.2.3 Using Name as a Locator");
        //●	Finding  Web element using Locator Name
        //        a.	Syntax : name =  Name of the element
        //        b.	Example : driver.findElement(By.name(“name”));
        System.out.println("Element found: " + driver.findElement(name("name")));

        System.out.println("Step 1.2.4 Using LinkText as a Locator");
        //●	Finding  Web element using Locator Link Text
        //        a.	Syntax : link =  partialLink  of the element
        //        b.	Example : driver.findElement(By.partialLinkText(“plink”));
        System.out.println("Element found: " + driver.findElement(By.partialLinkText("plink")));
//
        System.out.println("Step 1.2.5 Using Xpath as a Locator");
        //●	Finding  Web element using Locator Xpath
        //●	Xpath can be created in two ways
        System.out.println("\ta.	Relative Xpath");
        //●	Syntax : relativeXpath : //*[@class=’relativexapath’]
        //●	Example : driver.findElement(By.xpath(“//*[@class=’relativexapath’]”));
        System.out.println("Element found: " + driver.findElement(By.xpath("//*[@class='relativexapath']")));
//
        System.out.println("\tb.	Absolute Xpath");
        //●	Syntax : absoluteXpath :  html/body/div[1]/div[1]/div/h4[1]/b
        //●	Example : driver.findElement(By.xpath(“html/body/div[1]/div[1]/div/h4[1]/b”));
        System.out.println("Element found: " + driver.findElement(By.xpath("html/body/div[1]/div[1]/div/h4[1]/b")));
//
        System.out.println("Step 1.2.6 Using Xpath as a CSS Selector");
        //●	CSS Selector have many formats, namely
        System.out.println("\ta.	Tag and ID");
        //●	Syntax :”css = tag#id”
        //●	Example :  driver.findElement(By.cssSelector(“input#email”));
        System.out.println("Element found: " + driver.findElement(By.cssSelector("input#Email")));
//
        System.out.println("\tb.	Tag and Class");
        //●	Syntax : “css = tag.class”
        //●	Example : driver.findElement(By.cssSelector(”input.inputtext”));
        System.out.println("Element found: " + driver.findElement(By.cssSelector("input.inputtext")));
//
        System.out.println("\tc.	Tag and Attribute");
        //●	Syntax : “css = tag[attribute=value]”
        //●	Example : driver.findElement(By.cssSelector(“input[name=lastName]”));
        System.out.println("Element found: " + driver.findElement(By.cssSelector("input[name=lastName]")));
//
        System.out.println("\td.	Tag, Class and Attribute");
        //●	Syntax : “tag.class[attribute=value]”
        //●	Example : driver.findElement(By.cssSelector(“input.inputtext[tabindex=1]”));
        System.out.println("Element found: " + driver.findElement(By.cssSelector("input.inputtext[tabindex = '1']")));
//
        System.out.println("\te.	Inner text");
        //●	Syntax : ”css = tag.contains(“innertext”)”
        //●	Example : driver.findElement(By.cssSelector(font:contains(“Boston”)));
        //       driver.findElement(By.cssSelector("span[contains(text(),'Boston')]"));
//
//
        System.out.println("Step 1.2.7 Using Xpath Handling complex and Dynamic elements");
        //●	Dynamic Xpath has many formats, Namely
        System.out.println("\ta.	Contains();");
        //●	Syntax : “xpath = //*[contains(text(),’text’)]
        //●	Example : driver.findElement(By.xpath(”//*[contains(text(),’sub’]”));
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//*[contains(text(),'sub')]")));
//
        System.out.println("\tb.	Using OR & AND");
        //●	Syntax : xpath=//*[@type=’submit’ or @name=’btnReset’]
        //●	Example :
//        driver.findElement (By.xpath(”=//*[@type=’submit’ or @name=’btnReset’]”));
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//*[@type='submit' or @name='btnReset']")));
//
        System.out.println("\tc.	Start-with function");
        //●	Syntax : xpath= //label[starts-with(@id,’message’)]
        //●	Example : driver.findElement (By.xpath(”//label[starts-with(@id,’message’)]”));
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//label[starts-with(@id,'message')]")));
//
        System.out.println("\td.	Text();");
        //●	Syntax : xpath=//td[text()=’UserID’]
        //●	Example : : driver.findElement (By.xpath(”=//td[text()=’UserID’]”));
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//td[text()='UserID']")));
//
        System.out.println("\te.	Following");
//                ●	Syntax : xpath=//*[@type=’text’]//following::input
        //●	Example : driver.findElement(By.xpath(”=//*[@type=’text’]//following::input”));
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//*[@type='text']//following::input")));
//
        System.out.println("\tf.	Preceding");
        //●	Syntax : xpath=//*[@type=’text’]//preceding::input
        //●	Example : driver.findElement(By.xpath(”//*[@type=’text’]//preceding::input”));
//
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//*[@type='text']//preceding::input")));
//
        System.out.println("\tg.	Following - sibling");
        //●	Syntax : xpath=//*[@type=’submit’]//preceding::input
        //●	Example :
//        driver.findElement (By.xpath (”//*[@type=’text’]//following-sibling::input”));
        System.out.println("Element found: " +
                driver.findElement(By.xpath("//*[@type='text']//following-sibling::input")));

        //============ Lesson 1.3 ====================
        // 1.3.1 Using cssSelector

        //a.	Tag and ID
        //●	    Syntax: “css = tag#id”
        //●	    Example: driver.findElement(By.cssSelector(“input#email”));
        driver.findElement(By.cssSelector("input#Email"));

//        b.	Tag and Class
        //        ●	Syntax: “css = tag.class”
        //        ●	Example: driver.findElement(By.cssSelector(”input.inputtext”));
        driver.findElement(By.cssSelector("input.inputtext"));

//        C.	 Tag and Attribute
//        ●	Syntax: “css = tag[attribute=value]”
//        ●	Example: driver.findElement(By.cssSelector(“input[name=lastName]”));
        driver.findElement(By.cssSelector("input[name=lastName]"));

//        c.	Tag, Class and Attribute
        //    ●	Syntax: “tag.class[attribute=value]”
        //    ●	Example:
        driver.findElement(By.cssSelector("input.inputtext[tabindex='1']"));

//        d.	Inner text
        //●	Syntax: “css = tag.contains(“innertext”)”
        //●	Example: driver.findElement(By.cssSelector(font:contains(“Boston”)));
        //driver.findElement(By.cssSelector("h2:contains("Welcome")));

        WebElement el = driver.findElement(By .id("editbox")) ;
        System.out.println("editbox text:" + el.getAttribute("value")) ;
        el.clear();
        el.sendKeys("Hello!");
        System.out.println("editbox text:" + el.getAttribute("value")) ;

        System.out.println( "editbox exists?: " + (el != null)) ;
        System.out.println( "is editbox enabled: " + el.isEnabled()) ;

        el = driver.findElement(By.name("linkname")) ;

        System.out.println( "link exists?: " + (el != null)) ;
        System.out.println( "is link enabled: " + el.isEnabled()) ;
        System.out.println( "element name is: " + el.getAttribute("name")) ;
        //el.click();

        el = driver.findElement(By.cssSelector("button")) ;
        System.out.println( "button exists?: " + (el != null)) ;
        System.out.println( "button enabled: " + el.isEnabled()) ;
        el.click();

        el = driver.findElement(By.cssSelector("#id_checkbox")) ;
        System.out.println( "checkbox exists?: " + (el != null)) ;
        System.out.println( "checkbox enabled: " + el.isEnabled()) ;
        System.out.println( "checkbox selected: " + el.isSelected()) ;
        el.click();
        System.out.println( "checkbox selected: " + el.isSelected()) ;
        el.click();
        System.out.println( "checkbox selected: " + el.isSelected()) ;

        el = driver.findElement(By.cssSelector("input[type=radio]")) ;
        System.out.println( "radio enabled: " + el.isEnabled()) ;
        System.out.println( "radio selected: " + el.isSelected()) ;
        System.out.println( "radio displayed: " + el.isDisplayed()) ;

        el = driver.findElement(By.cssSelector("select")) ;
        Select sl  = new Select( el ) ;
        System.out.println( "selectList exists?: " + (el != null)) ;
        System.out.println( "selectList enabled: " + el.isEnabled()) ;
        sl.selectByVisibleText("Blue");
        sl.selectByIndex(1) ;
        System.out.println( "selectList count: " + sl.getOptions().size()) ;

        el = driver.findElement(By.cssSelector("table")) ;
        //No.of Columns
        //List <WebElement> col = driver.findElements(By.xpath(".//*[@id=\"id_tablediv\"]/table/thead/tr/td"));

        List <WebElement> col = driver.findElements(By.xpath(".//*[@id=\"id_tablediv\"]/table/tbody/tr[1]/td"));
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='id_tablediv']/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows.size());
        WebElement cell = driver.findElement(By.xpath(".//*[@id='id_tablediv']/table/tbody/tr[1]/td[1]")) ;
        System.out.println("cell value: " + cell.getText()) ;
        cell = driver.findElement(By.xpath(".//*[@id='id_tablediv']/table/tbody/tr[3]/td[3]")) ;
        System.out.println("cell value: " + cell.getText()) ;


        //el = driver.findElement(By.cssSelector("html")) ;
        //driver.switchTo().frame("id_iframe");
        //driver.switchTo().window( el.getDomProperty("id"));

        // Lessson 1.5
        //el = driver.findElement(By.cssSelector("#id_checkbox")) ;
        el = driver.findElement(By.cssSelector("#id_alert")) ;

//        el.click(); driver.switchTo().alert().accept();
//        el.click(); driver.switchTo().alert().dismiss();
        el.click(); System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        el.click(); System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        el = driver.findElement(By.cssSelector("#id_prompt")) ;

        el.click(); driver.switchTo().alert().sendKeys("text");
        System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        el.click(); driver.switchTo().alert().sendKeys("text");
        System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        el = driver.findElement(By.cssSelector("#id_confirm")) ;
        el.click() ; System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        el.click() ; System.out.println( driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //driver.findElement(cssSelector("input#id_lastName")).sendKeys(Keys.CONTROL + "t");
        //driver.findElement(By.id("lastName")).sendKeys(Keys.CONTROL + "w");

        driver.close() ;
    }
}

