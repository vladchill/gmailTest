package mail;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static utils.AllUtlis.switchWindow;
import static utils.ReporterCustom.log;

public class TestMailPage extends BaseTest{

    private MailPage mailPage;


    @BeforeClass
    public void setUp() {
        mailPage = new MailPage(driver);
    }



    @Test
    public void testEmailSendReceive(){

        mailPage.clickRedButton();
        log("open the sending frame");
        mailPage.sendMailWithValues("testoviyacc123456@gmail.com", "test theme", "test message");
        log("going to \"In messages\" folder");
        mailPage.clickInMessages();
        log("Checking mail");
        assertEquals("test theme", mailPage.getActTheme(), "theme of the letter is different");
        assertEquals(" - test message", mailPage.getActMessage(), "message of the letter is different");
    }

    @Test
    public void testChangeWindowsFocus(){
//        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector(".gb_b.gb_db")).click();
        driver.findElement(By.cssSelector(".gb_Fa.gb_Ie")).click();
        switchWindow(driver);
//        switchWindow(driver);

        String name = driver.findElement(By.cssSelector(".sPxS6d")).getText();
        assertEquals(name,"fghfgh", "test not equals");// assert for forged fail to test screenshot

    }

}
