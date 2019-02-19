package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login {
    By emailLocator= By.xpath("//*[@id=\"email\"]");
    By passwordLocator = By.xpath("//*[@id=\"passwd\"]");
    By signInLocator = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    WebDriver webDriver;

    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void populateEmail(String email){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(emailLocator).click();
        webDriver.findElement(emailLocator).clear();
        webDriver.findElement(emailLocator).sendKeys(email);
    }

    public void populatePassword(String password){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(passwordLocator).click();
        webDriver.findElement(passwordLocator).clear();
        webDriver.findElement(passwordLocator).sendKeys(password);
    }

    public void loginValidUser(String email, String password){
        populateEmail(email);
        populatePassword(password);
        clickSignIn();
        Header h= new Header(webDriver);
        h.signOutButtonIsVisible();
    }

    public void loginInvalidUser(String email, String password){
        populateEmail(email);
        populatePassword(password);
        clickSignIn();
    }

    public void clickSignIn(){
        webDriver.findElement(signInLocator).click();
    }
}
