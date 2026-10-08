package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    public static void takeScreenshot(
            WebDriver driver,
            String testName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            Path destination =
                    Path.of(
                            "test-output",
                            "screenshots",
                            testName + ".png"
                    );

            Files.createDirectories(
                    destination.getParent()
            );

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: " + destination
            );

        } catch (Exception e) {

            System.out.println(
                    "Unable to take screenshot: "
                            + e.getMessage()
            );
        }
    }
}