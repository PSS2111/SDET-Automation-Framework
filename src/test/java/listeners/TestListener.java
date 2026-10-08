package listeners;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        WebDriver driver =
                ((BaseTest) testClass).getDriver();

        String testName =
                result.getMethod().getMethodName();

        ScreenshotUtils.takeScreenshot(
                driver,
                testName
        );
    }
}