package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
    WebDriver webDriver;
    By accountEmailLocator = new By.ById("email_create");
    By createAccountLocator = new By.ByCssSelector("#SubmitCreate > span");

    public CreateAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void accountEmailField(String emailAddress) {
        WebElement element = webDriver.findElement(accountEmailLocator);
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountEmailLocator));
        element.sendKeys(emailAddress);
    }

    public void clickCreateAccount() {
        WebElement element = webDriver.findElement(createAccountLocator);
        element.click();
    }

}
