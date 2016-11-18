package mail;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
//    protected static LoginPage loginPage;

    public static WebDriver getDriver(){
        return driver;
    }


    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

//    @AfterClass
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
