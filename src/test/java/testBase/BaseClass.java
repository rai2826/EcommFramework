package testBase;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public Logger logger; // for logging

    public String browsername;
    public String browserversion;

    @BeforeClass
    @Parameters({"url", "browser"})
    public void setup(String ur, String br) {

        logger = LogManager.getLogger(this.getClass()); //logging , pass the class being executed
        WebDriverManager.chromedriver().setup();

        if (br.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        browsername = cap.getBrowserName();
        browserversion = cap.getBrowserVersion();

        driver.get(ur);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

        @AfterClass
        public void teardown(){
            driver.close();
        }
    }

