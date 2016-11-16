package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private static final String BASE_URL = "https://www.google.com.ua";

    private By inButton = By.cssSelector("#gb_70");
    private By userNameLocator = By.id("Email");
    private By nextButtonLocator = By.id("next");
    private By userPasswordLocator = By.id("Passwd");
    private By userLoginButtonLocator = By.id("signIn");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(BASE_URL);
    }

    public void setUsername(String username) {
        driver.findElement(userNameLocator).sendKeys(username);
    }

    public void clickNextButton() {
        driver.findElement(nextButtonLocator).click();
    }

    public void setPassword(String password) {
        driver.findElement(userPasswordLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(userLoginButtonLocator).click();
    }

    public void authorization(String username, String password) {
        driver.findElement(inButton).click();
        setUsername(username);
        clickNextButton();
        setPassword(password);
        clickLoginButton();
    }

}

