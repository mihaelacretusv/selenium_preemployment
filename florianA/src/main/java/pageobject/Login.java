package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
    By emailLocator = By.id("email");
    By passwordLocator = By.id("passwd");
    By signInLocator = By.id("SubmitLogin");
    By errorLocator = By.cssSelector("div.alert.alert-danger");

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }


    public void signIn() {
        driver.findElement(signInLocator).click();
    }

    public void populateEmail(String email) {
        WebElement element = driver.findElement(emailLocator);
        element.sendKeys(email);
    }

    public void populatePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void loginValidUser(String email, String password) {
        populateEmail(email);
        populatePassword(password);
        signIn();
    }

    public void loginInvalidUser(String email, String password) {
        populateEmail(email);
        populatePassword(password);
        signIn();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorLocator)));
    }

}
