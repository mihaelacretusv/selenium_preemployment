package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccount {

    WebDriver webDriver;

    private By emailAddress = By.id("email_create");
    private By createLocator = By.id("SubmitCreate");

    public CreateAccount(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void populateEmailAddress(String email) {
        webDriver.findElement(emailAddress).sendKeys(email);
    }

    public void clickCreateAccount() {
        webDriver.findElement(createLocator).click();
    }

    public void validCreate(String email) {
        populateEmailAddress(email);
        clickCreateAccount();
    }

}
