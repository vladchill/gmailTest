package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ReporterCustom.log;

public class LoginPage {
    private WebDriver driver;
    private static final String BASE_URL = "https://www.google.com.ua";

    @FindBy(css = "#gb_70")
    private WebElement inButton;

    @FindBy(id = "Email")
    private WebElement userNameLocator;

    @FindBy(id = "next")
    private WebElement nextButtonLocator;

    @FindBy(id = "Passwd")
    private WebElement userPasswordLocator;

    @FindBy(id = "signIn")
    private WebElement userLoginButtonLocator;

    @FindBy(linkText = "Почта")
    private WebElement emailLinkLocator;

    @FindBy(css = ".gb_b.gb_db")
    private WebElement emailLoginTitleLocator;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        userNameLocator.sendKeys(username);
    }

    public void clickNextButton() {
        nextButtonLocator.click();
    }

    public void setPassword(String password) {
        userPasswordLocator.sendKeys(password);
    }

    public void clickLoginButton() {
        userLoginButtonLocator.click();
    }

    public void authorization(String username, String password) {
        inButton.click();
        setUsername(username);
        clickNextButton();
        setPassword(password);
        clickLoginButton();
        log("User is authorized");
    }

    public void clickMailLink(){
        emailLinkLocator.click();
        log("Mail page is shown");
    }

    public String getEmailLoginTitle(){

        System.out.println(emailLoginTitleLocator.getAttribute("title"));
        String loginTitle = emailLoginTitleLocator.getAttribute("title");
        log("Login title is " + loginTitle);
        return loginTitle;
    }

}

