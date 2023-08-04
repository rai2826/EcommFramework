package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;  // UI of the report
    public ExtentReports extent;  //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test methods

    public void onStart(ITestContext context) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        sparkReporter=new ExtentSparkReporter("\\C:\\Users\\d629263\\IdeaProjects\\Opencart_3rdAug\\reports\\" + "myReport" +timeStamp+".html");//specify location of the report

        sparkReporter.config().setDocumentTitle("Test Automation Report"); // TiTle of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        BaseClass bc=new BaseClass();
        extent.setSystemInfo("Application Name","Para Bank");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","Gaurav");
        extent.setSystemInfo("os","Windows10");

        String bname= bc.browsername;
        extent.setSystemInfo("Browser name", bname);
        extent.setSystemInfo("Browser version", bc.browserversion);
        //extent.setSystemInfo("Browser URL", bc.driver.getCurrentUrl());

    }


    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getName()); // create a new enty in the report
        test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

    }

    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());

    }

    public void onTestSkipped(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

    }


    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
