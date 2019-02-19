package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccount {

    By emailInputLabel = By.id("email_create");
    By createAccButton = By.xpath("//*[@id=\"SubmitCreate\"]/span");
    WebDriver webDriver;

    public CreateAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterEmail(String email) {
        WebElement setEmail = webDriver.findElement(emailInputLabel);
        setEmail.click();
        setEmail.sendKeys(email);


    }

    public void clickRegister() {
        WebElement registerButton = webDriver.findElement(createAccButton);
        registerButton.click();
    }


}
