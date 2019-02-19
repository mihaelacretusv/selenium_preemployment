package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAnAccount {
   private  By emailLocator= By.id("email_create");
    private By createAnAccountLocator=By.id("SubmitCreate");
    WebDriver webDriver;

    public CreateAnAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void populateEmailAddress(String emailAddress){
        webDriver.findElement(emailLocator).sendKeys(emailAddress);
    }


    public void clickCreateAnAccount(){
        webDriver.findElement(createAnAccountLocator).click();
    }

    public void createAccount(String emailAddress){
        populateEmailAddress(emailAddress);
       clickCreateAnAccount();
    }
}
