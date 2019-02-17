package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private By usernameLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By submitLocator = By.id("SubmitLogin");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void populateUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void populatePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void pressSubmitBtn() {
        driver.findElement(submitLocator).click();
    }

    public void loginWith(String username, String password) {
        populateUsername(username);
        populatePassword(password);
        pressSubmitBtn();
    }
}
