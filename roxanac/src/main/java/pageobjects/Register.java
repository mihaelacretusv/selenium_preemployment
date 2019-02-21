package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    By createAccountLocator = By.cssSelector("#SubmitCreate > span");
    By emailAddressCreateAccountLocator = By.name("email_create");
    WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyEmailAddressFormat(String emailAddress ){

    }

    public void clickCreateAccountButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(createAccountLocator)));
        WebElement element = driver.findElement(createAccountLocator);
        element.click();
    }
    public void populateEmailAddressFieldCreateAccount(String email)
    {
        WebElement element = driver.findElement(emailAddressCreateAccountLocator);
        element.clear();
        element.sendKeys(email);

    }
    public void insertValidEmailAddress(String email)
    {
        populateEmailAddressFieldCreateAccount(email);
        clickCreateAccountButton();

    }
}
