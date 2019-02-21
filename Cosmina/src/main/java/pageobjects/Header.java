package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class Header {

    WebDriver webDriver;
    By signInLocator = By.className("login");
    By signOutLocator = By.className("logout");
    By checkUserName = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");

    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickSignIn() {

        webDriver.findElement(signInLocator).click();

    }

    public void clickSignOut() {

        webDriver.findElement(signOutLocator).click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void checkUserName(String firstName, String lastName) {

        WebElement element = webDriver.findElement(checkUserName);
        String actualValue = element.getText();

        Assert.assertEquals(actualValue, firstName + " " + lastName);

    }

}

