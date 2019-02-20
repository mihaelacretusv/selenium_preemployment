package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Header {

    By signInLocator = By.linkText("Sign in");
    By signOutLocator = By.linkText("Sign out");
    By usernameLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");


    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(signInLocator)));
        WebElement element = driver.findElement(signInLocator);
        element.click();
    }

    public void clickSignOut(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(signOutLocator)));
        WebElement element = driver.findElement(signOutLocator);
        element.click();

    }
    public void checkUsername(String firstName, String lastName ){
        WebElement element = driver.findElement(usernameLocator);
        String username = element.getText();
        String[] splitUsername = username.split(" ");
        Assert.assertEquals(firstName, splitUsername[0]);
        Assert.assertEquals(lastName, splitUsername[1]);
    }
    public void signInVisibleButton(){
        WebElement element = driver.findElement(signOutLocator);
        Boolean isVisible = element.isDisplayed();
        Assert.assertEquals(isVisible,Boolean.TRUE);
    }
}
