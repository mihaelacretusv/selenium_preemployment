package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccount {
    By cartLocator = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]");
    By searchBarLocator = By.xpath("//*[@id=\"search_query_top\"]");
    By homeLocator = By.xpath("//*[@id=\"center_column\"]/ul/li/a/span");

    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCart(){
        driver.findElement(cartLocator).click();
    }
    public void clickHome(){
        driver.findElement(homeLocator).click();
    }
    public void checkSearchInput(String searchSomething){
        WebElement element = driver.findElement(searchBarLocator);
       String searchElement = element.getAttribute("value");
        Assert.assertEquals(searchElement, searchSomething);
    }
}
