package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountsRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RandomFNameGenerator;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test
    public void test_account_registration(){

        logger.info("===========================================================================================");
        logger.info("*********Starting TC_001_AccountRegistrationTest **********");
        logger.info("** test is running in **" + browsername +"========="+ browserversion);
        try {
            HomePage hp = new HomePage(driver);

            hp.clickRegister();

            logger.info("******clicked on the register link*******");

            AccountsRegistrationPage arp = new AccountsRegistrationPage(driver);

            RandomFNameGenerator rfname=new RandomFNameGenerator();
            String randomFirstName=rfname.fnameGen();

            arp.enterFirstName(randomFirstName);
            logger.info("**** Entered the first name" + randomFirstName);

            arp.enterLastName(randomFirstName+"last");
            logger.info("**** Entered the last name  ******" + randomFirstName+"last");

            arp.enterAddress("Test Address");
            arp.enterCity("test city");
            arp.enterState("Test State");
            arp.enterZip("3064");
            arp.enterPhone("123456789");
            arp.enterSsn("1234");
            logger.info("************Entered address,city,state,zip,phone and SSN*************");

            arp.enterUserName(randomFirstName+"."+randomFirstName);
            logger.info("*******Enter the username*********" +randomFirstName+"."+randomFirstName);

            arp.enterPassWord(randomFirstName+"1234");
            logger.info("***Enter the password******" +randomFirstName+"1234");
            arp.enterRepeatPassword(randomFirstName+"1234");
            arp.clickRegister();

            String wmessage = arp.welcomeMsg();
            Assert.assertEquals(wmessage, "Welcome");
            logger.info("*******Registration successful***********");

            System.out.println("username is " + randomFirstName+"."+randomFirstName);
            System.out.println("password is " + randomFirstName+"1234");
        }
        catch (Exception e){
            Assert.fail("Test Case caught Exception");
        }


    }


}
