package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//HomePage extends the BasePage class and the constructor calls the constructor of parent class
public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Finding  Elements using PageFactory approach



    @FindBy(xpath = "//a[text()=\"Register\"]")
    WebElement linkRegister;

    //  Action methods



    public void clickRegister(){
        linkRegister.click();
    }
}
