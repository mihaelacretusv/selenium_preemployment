package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccount {
    WebDriver webDriver;
    By myAccount = new By.ByCssSelector("#center_column > div > div:nth-child(2) > ul > li > a > span");

    public MyAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void CheckMyAccountText() {
        Assert.assertTrue(webDriver.getPageSource().contains("My wishlists"));
    }
}
