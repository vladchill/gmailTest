package utils;


import mail.BaseTest;
import mail.TestMail;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;

import static utils.ReporterCustom.*;

public class AllUtlis {


    public static void switchWindow(WebDriver driver){
        String currentWindow = driver.getWindowHandle();
        log("Current Window URL is : " + driver.getCurrentUrl());
        System.out.println("Current Window URL is : " + driver.getCurrentUrl());

        for (String handle: driver.getWindowHandles() ) {
            if (!handle.equals(currentWindow)){
                driver.switchTo().window(handle);
                break;
            }
        }
        System.out.println("Active Window URL is : " + driver.getCurrentUrl());
        log("Active Window URL is : " + driver.getCurrentUrl());

    }

    public static void makeScreenshot(String message) {
        makeScreenshot(message, "");
    }

    public static void makeScreenshot(String message, String screenshotName) {
        log(message);
        String imageName = screenshotName + System.currentTimeMillis() + ".png";
        String path = ".\\target\\screenshots\\";//System.getProperty("image.dir") + File.separatorChar + "html" + File.separatorChar;
        try {
            File screenshotAs = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);//future change bfore driver
            FileUtils.copyFile(screenshotAs, new File(path + imageName));
            log("<a href='" + imageName + "'><img src='" + imageName + "' width='600'/></a>");
        } catch (Exception e) {
            Reporter.log("Failed to save screenshot <br></br> " + e);
        }
    }

}
