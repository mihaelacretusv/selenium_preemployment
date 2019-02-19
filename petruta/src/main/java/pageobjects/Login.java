package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login {
    private By emailLocator = By.xpath("//*[@id=\"email\"]");
    private By passwordLocator = By.xpath("//*[@id=\"passwd\"]");
    private By signInLocator = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    private By errorAlert = By.cssSelector("div.alert.alert-danger");
    private By emailLocatorRegister = By.xpath("//*[@id=\"email_create\"]");
    private By createAnAccount = By.xpath("//*[@id=\"SubmitCreate\"]/span");
    private By invalidEmailAddress = By.xpath("//*[@id=\"create_account_error\"]/ol/li");


    WebDriver webDriver;

    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void populateEmail(String email) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(emailLocator).click();
        webDriver.findElement(emailLocator).sendKeys(email);

    }

    public void populatePassword(String password) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(passwordLocator).click();
        webDriver.findElement(passwordLocator).sendKeys(password);
    }

    public void loginValidUser(String email, String password) {
        populateEmail(email);
        populatePassword(password);
        clickSignIn();
        Header h = new Header(webDriver);
        h.signOutButtonIsVisible();
    }

    public void clickSignIn() {
        webDriver.findElement(signInLocator).click();
    }

    public void loginInvalidUser(String email, String password) {
        populateEmail(email);
        populatePassword(password);
        clickSignIn();
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorAlert)));

    }

    public void populateEmailRegister(String email) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(emailLocatorRegister).click();
        webDriver.findElement(emailLocatorRegister).sendKeys(email);

    }

    public void clickCreateAnAccount() {
        webDriver.findElement(createAnAccount).click();
    }
    public void createAnValidAccount(String email){
        populateEmailRegister(email);
        clickCreateAnAccount();
    }

    public void createAnInvalidAccount(String email){
        populateEmailRegister(email);
        clickCreateAnAccount();
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(invalidEmailAddress)));
    }

    public void tryInsertValidEmailButInvalidPassword(){}
    public void checkCreateAnAccountButton(){}

}


