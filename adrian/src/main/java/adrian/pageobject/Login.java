package adrian.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

    public WebDriver driver;
    By emailLocator = By.xpath("//input[@id=\"email\"]");
    By passwordLocator = By.xpath("//input[@id=\"passwd\"]");
    By pressSignIn = By.id("SubmitLogin");

    private By errorLocator = By.cssSelector("div.alert.alert-danger");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void populateEmailField(String emailadress) {
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(emailadress);
    }

    public void populatePasswordField(String password) {
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void pressSignIn() {
        driver.findElement(pressSignIn).click();
    }

    public void loginValidUser(String email, String password) {
        populateEmailField(email);
        populatePasswordField(password);
        pressSignIn();

        Header header = new Header(this.driver);
        header.signOutButtonVisible();
    }

    public void loginInvalidUser(String wrongEmail, String password) {
        populateEmailField(wrongEmail);
        populatePasswordField(password);
        pressSignIn();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));

        Assert.assertTrue(driver.findElement(errorLocator).isDisplayed());
    }

}
