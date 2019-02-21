package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Header {
   By signInLocator= By.linkText("Sign in");
   By signOutLocator = By.className("header_user_info");
   By numeLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
   WebDriver webDriver;

    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickSignIn(){
        webDriver.findElement(signInLocator).click();
    }

    public void clickSignOut(){
        webDriver.findElement(signOutLocator).click();


    }

    public void checkUserName(String name, String prenume){
        Assert.assertEquals(webDriver.findElement(numeLocator).getText(),name + " " + prenume);
    }

    public void signOutButtonIsVisible() {
        WebElement element = webDriver.findElement(signOutLocator);
        Assert.assertTrue(element.isDisplayed());

    }
}

