package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Header {

    WebDriver webDriver;
    By signInLocator = new By.ByClassName("login");
    By signOutLocator = new By.ByClassName("logout");
    By userLocator = new By.ByCssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");

    public Header( WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickSignIn(){
       WebElement element = webDriver.findElement(signInLocator);
        element.click();
    }

    public void clickSignOut(){
        WebElement element = webDriver.findElement(signOutLocator);
        element.click();
    }

    public void checkUser(String firstName, String lastName){
        WebElement element = webDriver.findElement(userLocator);
        element.getText();
        Assert.assertEquals(element.getText(),firstName + " " + lastName);
    }
    public void signOutButtonIsVisible(){
        WebElement element = webDriver.findElement(signOutLocator);
        Assert.assertTrue(element.isDisplayed());
    }
}
