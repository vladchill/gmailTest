package mail;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import static utils.AllUtlis.*;
import static utils.ReporterCustom.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestMail {

    public static WebDriver driver;
    private static LoginPage loginPage;
    private final By emailLinkLocator = By.linkText("Почта");
    private final By emailLoginTitleLocator = By.cssSelector(".gb_b.gb_db");

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testGmail1() {

        loginPage.authorization("testoviyacc123456", "zaqxswcde12345678");
        driver.findElement(emailLinkLocator).click();

        System.out.println(driver.findElement(emailLoginTitleLocator).getAttribute("title"));
        String loginTitle = driver.findElement(emailLoginTitleLocator).getAttribute("title");
        log("Login title is " + loginTitle);
        assertTrue(loginTitle.contains("testoviyacc123456@gmail.com"),
                "login not contains testoviyacc123456@gmail.com");
    }

    @Test
    public void testGmail2(){

        driver.findElement(By.cssSelector(".z0 div")).click();//red button
        driver.findElement(By.cssSelector(".wO textarea")).sendKeys("testoviyacc123456@gmail.com");//text field for whom
        driver.findElement(By.cssSelector(".aoD.az6 input")).sendKeys("test theme");
        driver.findElement(By.cssSelector(".Ar.Au .Am")).sendKeys("test message");
        driver.findElement(By.cssSelector(".aDh .T-I")).click();//send
        driver.findElement(By.cssSelector(".aio")).click();//in messages

        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".Cp")));

        String actTheme = driver.findElement(By.cssSelector(".Cp .y6 span:first-child")).getText();
        String actMessage = driver.findElement(By.cssSelector(".Cp .y6 span:last-child")).getText();
        log("Checking mail");
        assertEquals("test theme", actTheme, "theme of the letter is different");
        assertEquals(" - test message", actMessage, "message of the letter is different");
    }

    @Test
    public void testGmail3(){
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector(".gb_b.gb_db")).click();
        driver.findElement(By.cssSelector(".gb_Fa.gb_Ie")).click();
        switchWindow(driver);
//        switchWindow(driver);


        String name = driver.findElement(By.cssSelector(".sPxS6d")).getText();
        assertEquals(name,"fghfgh", "test not equals");

    }

    public static WebDriver getDriver(){
        return driver;
    }



//    @AfterClass
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


}
