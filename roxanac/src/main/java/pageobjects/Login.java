package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
   private By emailInputLocator = By.xpath("//*[@id=\"email\"]");
    By passwordInputLocator = By.xpath("//*[@id=\"passwd\"]");
    By signInLocator = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    By errorLocator = By.cssSelector("div.alert.alert-danger");
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;

    }

    public void clickSignInButtonToSubmit(){
        driver.findElement(signInLocator).click();
    }
    public void populateEmailField(String emailAddress){
        WebElement element = driver.findElement(emailInputLocator);
        element.clear();
        element.sendKeys(emailAddress);
    }
    public void populatePasswordField(String password){
        WebElement element = driver.findElement(passwordInputLocator);
        element.clear();
        element.sendKeys(password);
    }
    public void loginValidUser(String emailAddress, String password){
        populateEmailField(emailAddress);
        populatePasswordField(password);
        clickSignInButtonToSubmit();
    }
    public void loginInvalidUser(String email, String password)
    {
        populateEmailField(email);
        populatePasswordField(password);
        clickSignInButtonToSubmit();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(errorLocator);
        wait.until(ExpectedConditions.visibilityOf(element));
        Boolean isVisible= element.isDisplayed();
        Assert.assertEquals(isVisible,Boolean.TRUE);

    }
}
