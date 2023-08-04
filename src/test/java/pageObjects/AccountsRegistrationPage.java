package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsRegistrationPage extends BasePage{
    public AccountsRegistrationPage(WebDriver driver) {
        super(driver);
    }


    //finding elements and use PageFactory

    @FindBy(name="customer.firstName")
    WebElement txtFirstname;

    @FindBy(name = "customer.lastName")
    WebElement txtLastname;

    @FindBy(name="customer.address.street")
    WebElement txtAddress;

    @FindBy(name="customer.address.city")
    WebElement txtCity;

    @FindBy(name="customer.address.state")
    WebElement txtState;


    @FindBy(name = "customer.address.zipCode")
    WebElement txtZip;

    @FindBy(name="customer.phoneNumber")
    WebElement txtPhone;

    @FindBy(name = "customer.ssn")
    WebElement txtSSN;

    @FindBy(name = "customer.username")
    WebElement txtUsername;



    @FindBy(name = "customer.password")
    WebElement txtPassword;

    @FindBy(name="repeatedPassword")
    WebElement txtRepeatPassword;



    @FindBy(xpath = "//input[@value=\"Register\"]")
    WebElement btnContinue;

    @FindBy(xpath = "//div/p/b[text()=\"Welcome\"]")
    WebElement msg;

    public void enterFirstName(String fname)
    {
        txtFirstname.sendKeys(fname);
    }

    public void enterLastName(String lname){
        txtLastname.sendKeys(lname);
    }

    public void enterPassWord(String pwd){
        txtPassword.sendKeys(pwd);

    }

    public void enterAddress(String add){
        txtAddress.sendKeys(add);
    }

    public void enterCity(String city){
        txtCity.sendKeys(city);
    }

    public void enterState(String state){
        txtState.sendKeys(state);
    }

    public void enterZip(String zip){
        txtZip.sendKeys(zip);
    }

    public void enterPhone(String phone){
        txtPhone.sendKeys(phone);
    }

    public void enterSsn(String ssn){
        txtSSN.sendKeys(ssn);
    }

    public void enterUserName(String uname){
        txtUsername.sendKeys(uname);
    }

    public void enterPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }

    public void enterRepeatPassword(String pwd){
        txtRepeatPassword.sendKeys(pwd);
    }

    public void clickRegister(){
        btnContinue.click();
    }

    public String welcomeMsg(){
       return  msg.getText();
    }
}
