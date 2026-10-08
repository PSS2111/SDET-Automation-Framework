package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Run headless only in CI/GitHub Actions
            if (System.getenv("CI") != null) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            return new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            return new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            return new EdgeDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }
    }
}