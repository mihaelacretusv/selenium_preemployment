package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login {

    WebDriver webDriver;

    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By signInLocator = By.id("SubmitLogin");
    private By errorLocator = By.cssSelector("div.alert.alert-danger");

    public Login(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void populateEmailAddress(String email) {

        webDriver.findElement(emailAddressLocator).clear();

        webDriver.findElement(emailAddressLocator).sendKeys(email);

    }

    public void populatePassword(String password) {

        webDriver.findElement(passwordLocator).clear();

        webDriver.findElement(passwordLocator).sendKeys(password);

    }

    public void clickSignIn() {

        webDriver.findElement(signInLocator).click();

    }

    public void loginValidUser(String Email, String Password) {

        populateEmailAddress(Email);
        populatePassword(Password);
        clickSignIn();
    }

    public void loginInvalidUser(String email, String pass) {

        populatePassword(pass);
        populateEmailAddress(email);
        clickSignIn();

        Assert.assertTrue(webDriver.findElement(errorLocator).isDisplayed());
    }


}
