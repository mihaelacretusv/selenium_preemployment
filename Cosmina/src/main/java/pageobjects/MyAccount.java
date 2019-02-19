package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {

    WebDriver webDriver;

    By cartLocator = By.className("shopping_cart");
    By searchBoxLocator = By.id("searchbox");

    public MyAccount(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void clickCart() {

        webDriver.findElement(cartLocator).click();
    }

    public void typeSearch() {

        webDriver.findElement(searchBoxLocator).sendKeys();
    }
}
