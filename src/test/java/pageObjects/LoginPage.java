package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="username")
    WebElement lUname;

    @FindBy(name="password")
    WebElement lpwd;

    @FindBy(xpath = "//input[@value=\"Log In\"]")
    WebElement lsubmit;

    @FindBy(xpath = "//div/p/b[text()=\"Welcome\"]")
    WebElement msg;



    public void enterlUname(String username){
        lUname.sendKeys(username);
    }

    public void enterlpwd(String pwd){
        lpwd.sendKeys(pwd);
    }

    public void clicklogin() {
        lsubmit.click();
    }
        public String welcomeMsg(){
            return  msg.getText();
        }
    }


