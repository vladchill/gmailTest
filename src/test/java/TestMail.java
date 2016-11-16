import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMail {
//    private static final String BASE_URL = "https://www.bing.com/";
//    private static By formSearch = By.cssSelector("div.search_controls  div.b_searchboxForm input.b_searchbox");
//    private static By headers = By.cssSelector("ol#b_results li .b_title h2");
//    private static String searchText = "automotation";

    private static WebDriver driver;
    private static LoginPage loginPage;
    private final By emailLinkLocator = By.linkText("Почта");
    private final By emailLoginTitleLocator = By.cssSelector(".gb_b.gb_db");

    @BeforeMethod
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
        assertTrue(loginTitle.contains("testoviyacc123456@gmail.com"),
                "login not contains testoviyacc123456@gmail.com");

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
        assertEquals("test theme", actTheme, "theme of the letter is different");
        assertEquals(" - test message", actMessage, "message of the letter is different");
    }

    @Test
    public void testGmail2(){

    }

















//

//    @After
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }



}
