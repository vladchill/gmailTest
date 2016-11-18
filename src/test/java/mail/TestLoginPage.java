package mail;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import static utils.AllUtlis.*;
import static utils.ReporterCustom.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestLoginPage extends BaseTest {

    private LoginPage loginPage;


    @BeforeClass
    private void initPage() {
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testLoginPageAppearCorrect() {

        loginPage.authorization("testoviyacc123456", "zaqxswcde12345678");
        loginPage.clickMailLink();
        assertTrue(loginPage.getEmailLoginTitle().contains("testoviyacc123456@gmail.com"),
                "login not contains testoviyacc123456@gmail.com");
    }


}
