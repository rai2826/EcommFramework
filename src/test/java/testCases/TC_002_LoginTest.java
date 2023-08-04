package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.util.ResourceBundle;

public class TC_002_LoginTest extends BaseClass {



//public static ResourceBundle rb1;

@Test
public void testlogin(){

    LoginPage lpage=new LoginPage(driver);

    lpage.enterlUname(rb.getString("userName"));
    lpage.enterlpwd(rb.getString("passWord"));
    lpage.clicklogin();

    String wmessage = lpage.welcomeMsg();
    Assert.assertEquals(wmessage, "Welcome");
    logger.info("*******Login successful***********");

}



}
