package Utilities;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Elementutils {
    WebDriver driver;
    public Elementutils(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement waitforelement(WebElement element, long durationInseconds)
    {
        //WebElement webelement =null;

        try
        {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInseconds));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (TimeoutException e)
        {
            throw new RuntimeException("Element not clickable within"+durationInseconds+"seconds");
        }

    }
    public void clickonelement(WebElement element,long durationInseconds)
    {
        WebElement webelement=waitforelement(element,durationInseconds);
        webelement.click();
    }
    public void typetextintoelement(WebElement element,String input,long durationInseconds)
    {
        WebElement webelement=waitforelement(element,durationInseconds);
        webelement.click();
        webelement.clear();
        webelement.sendKeys(input);
    }
    public WebElement waitforvisibilityelement(WebElement element,long durationInseconds)
    {
        // WebElement webelement =null;

        try
        {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationInseconds));
            return wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException e)
        {
            throw new RuntimeException("Element not clickable within"+durationInseconds+"seconds");
        }
        //return webelement;
    }
    public boolean displaystatusofelement(WebElement element,long durationInseconds)
    {
        WebElement webelement=waitforvisibilityelement(element,durationInseconds);
        return webelement.isDisplayed();

    }
    public String gettextfroelement(WebElement element,long durationInseconds)
    {
        WebElement webelement=waitforvisibilityelement(element,durationInseconds);
        return webelement.getText();
    }
}
