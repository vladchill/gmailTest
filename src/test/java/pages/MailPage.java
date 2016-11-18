package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;
    private static final String URL_MATCH = "mail";
//    private static final String BASE_URL = "https://www.google.com.ua";

    @FindBy(css = ".z0 div")
    private WebElement redButton;

    @FindBy(css = ".wO textarea")
    private WebElement emailField;

    @FindBy(css = ".aoD.az6 input")
    private WebElement themeField;

    @FindBy(css = ".Ar.Au .Am")
    private WebElement messageField;

    @FindBy(css = ".aDh .T-I")
    private WebElement sendButton;

    @FindBy(css = ".aio")
    private WebElement inMessagesLink;

    @FindBy(css = ".Cp .y6 span:first-child")
    private WebElement mailTheme;

    @FindBy(css = ".Cp .y6 span:last-child")
    private WebElement mailMessage;


    public MailPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {// Is it accepted???
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        this.driver = driver;
//        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }


    public void clickRedButton(){
        redButton.click();
    }

    private void typeEmail(String email){
        emailField.sendKeys(email);
    }

    private void typeTheme(String theme){
        themeField.sendKeys(theme);
    }

    private void typeMessage(String message){
        messageField.sendKeys(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void clickInMessages(){
        inMessagesLink.click();
    }
    public void sendMailWithValues(String email, String theme, String message){
        typeEmail(email);
        typeTheme(theme);
        typeMessage(message);
        clickSendButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".Cp")));// FindBy???
    }

    public String getActTheme(){
        return mailTheme.getText();
    }

    public String getActMessage(){
        return mailMessage.getText();
    }


}
