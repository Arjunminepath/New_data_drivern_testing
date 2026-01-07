package Pages;

import Utilities.Elementutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    WebDriver driver;

    private Elementutils utils;

    public Loginpage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utils=new Elementutils(driver);

    }


    @FindBy(id="input-email")
    WebElement emailfield_lgn;

    @FindBy(id="input-password")
    WebElement pwdfield_lgn;

    @FindBy(xpath="//input[@type='submit']")
    WebElement lgn_button;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    WebElement warningmessage;

    public void enteremail(String emailtext)
    {
        utils.typetextintoelement(emailfield_lgn,emailtext,15);
    }
    public void enterpwd(String pwd)
    {
        utils.typetextintoelement(pwdfield_lgn,pwd,15);
    }
    public Accountpage login_btn()
    {
        utils.clickonelement(lgn_button,15);
        return new Accountpage(driver);
    }

    public String warningmessage_vrfctn()
    {
        return utils.gettextfroelement(warningmessage,15);

    }


}
