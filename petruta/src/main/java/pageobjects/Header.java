package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Header {
WebElement element;
    By singInLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By singOutLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
    By nameLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
    WebDriver driver;

    public Header(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void clickSingIn() {

        driver.findElement(singInLocator).click();
    }

    public void clickSingOut() {
        driver.findElement(singOutLocator).click();
    }

    public void checkUserName(String name, String prenume) {

         Assert.assertEquals(driver.findElement(nameLocator).getText(),name+" " +prenume);
    }


    public void signOutButtonIsVisible() {
        WebElement element = driver.findElement(singOutLocator);
        Assert.assertTrue(element.isDisplayed());

    }
}
