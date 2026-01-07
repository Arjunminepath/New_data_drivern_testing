package Pages;

import Utilities.Elementutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
    WebDriver driver;

    private Elementutils utils;

    @FindBy(xpath="//div[@id='content']/h2[1]")
    WebElement successmessage;

    public boolean successmessageverification()
    {
        if(utils.displaystatusofelement(successmessage,15))
    {
        return successmessage.getText().equalsIgnoreCase("My Account");
    }
        return false;
    }
    public Accountpage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utils=new Elementutils(driver);
    }

}
