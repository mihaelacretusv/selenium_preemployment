package adrian.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAnAccount {
    public WebDriver driver;

    By emailRegister = By.id("email_create");
    By pressCreateAccount = By.id("SubmitCreate");


    public CreateAnAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void populateEmailField(String mailforregister) {
        driver.findElement(emailRegister).sendKeys(mailforregister);
    }

    public void clickcreateNewAccount() {
        driver.findElement(pressCreateAccount).click();
    }

    public void populateEmailFieldWithCorrectlyValue(String registermail) {
        populateEmailField(registermail);
        clickcreateNewAccount();
    }

}
