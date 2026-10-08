package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    public void setup() {

        String browser = ConfigReader.get("browser");
        String baseUrl = ConfigReader.get("baseUrl");

        driver = DriverFactory.createDriver(browser);

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}