package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
    Header header;
    WebDriver webDriver;
    By emailInputLocator = By.name("email");
    By passwordLocator = By.name("passwd");
    By signInLocator = By.xpath("//*[@id=\"SubmitLogin\"]/span");

    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void populateEmail(String emailAddress) {
        webDriver.findElement(emailInputLocator).sendKeys(emailAddress);

    }

    public void populatePassword(String password){
        webDriver.findElement(passwordLocator).sendKeys(password);

    }
    public void clickSignIn(){
        webDriver.findElement(signInLocator).click();
    }
    public void logInValidUser(String email,String pass){
        populateEmail(email);
        populatePassword(pass);
        clickSignIn();
        header.checkUserName("Mihaela","Cretu");

    }

}
