import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeGridTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);

        URL url = new URL("http://192.168.4.24:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);

        driver.get("https://www.google.com");
        System.out.println("Google Title: " + driver.getTitle());

        driver.close();
    }
}
