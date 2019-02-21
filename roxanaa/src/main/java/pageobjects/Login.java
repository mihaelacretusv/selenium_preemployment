package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

    WebDriver webDriver;
    By emailLocator = new By.ByName("email");
    By passwordLocator = new By.ByName("passwd");
    By signInButton = new By.ByCssSelector("#SubmitLogin > span");
    By errorLocator = new By.ByCssSelector("#center_column > div.alert.alert-danger");

    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void populateEmailField(String emailAddress) {
        WebElement element = webDriver.findElement(emailLocator);
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        element.sendKeys(emailAddress);
    }

    public void populatePasswordField(String password) {
        WebElement element = webDriver.findElement(passwordLocator);
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        element.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement element = webDriver.findElement(signInButton);
        element.click();
    }

    public void loginValidUser(String emailAddress, String password) {

        populateEmailField(emailAddress);
        populatePasswordField(password);
        clickSignInButton();
        Header header = new Header(webDriver);
        header.signOutButtonIsVisible();
    }

    public void loginInValidUser(String invalidEmailAddress, String invalidPassword) {
        populateEmailField(invalidEmailAddress);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        populatePasswordField(invalidPassword);
        clickSignInButton();
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        WebElement error = webDriver.findElement(errorLocator);
        Assert.assertTrue(error.isDisplayed());
    }


}

