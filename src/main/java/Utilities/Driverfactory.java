package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driverfactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver Initializebrowser(String browsername) {
        WebDriver webdriver = null;

        if (browsername.equals("chrome")) {
            webdriver = new ChromeDriver();

        } else if (browsername.equals("firefox")) {
            webdriver = new FirefoxDriver();
        } else if (browsername.equals("edge")) {
            webdriver = new EdgeDriver();
        } else if (browsername.equals("safari")) {
            webdriver = new SafariDriver();
        }
        driver.set(webdriver);
        driver.get().manage().deleteAllCookies();
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Common_utils.PAGE_LOAD_TIME));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Common_utils.IMPLICIT_WAIT_TIME));

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
