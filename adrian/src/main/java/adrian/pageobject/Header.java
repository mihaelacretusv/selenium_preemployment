package adrian.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Header {

    public WebDriver driver;
    By signInLocator = By.className("login");
    By signOutLocator = By.className("logout");
    By userActive = By.xpath("//div[@class=\"header_user_info\"]/a/span");
    By viewShopPhone = By.className("shop-phone");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInLocator).click();
    }

    public void clickSignOut() {
        driver.findElement(signOutLocator).click();
    }

    public void checkUserName(String userName) {
        WebElement user = driver.findElement(userActive);
        Assert.assertEquals(user, userName);
    }

    public void signOutButtonVisible() {
        Assert.assertTrue(driver.findElement(signOutLocator).isDisplayed());
    }

    public void checkShopPhone(String myText, String phoneNumber) {
        WebElement shop = driver.findElement(viewShopPhone);
        Assert.assertEquals(shop, myText + " " + phoneNumber);
    }

}
