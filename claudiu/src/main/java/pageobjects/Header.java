package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Header {

    By signLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By signOutLocator = By.className("logout");
    By userName = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");


    WebDriver drive;

    public Header() {

    }

    public Header(WebDriver drive) {
        this.drive = drive;
    }

    public void clickSignIn() {
        WebElement signin = drive.findElement(signLocator);
        signin.click();
    }

    public void clickSignOut() {
        WebElement signout = drive.findElement(signOutLocator);
        signout.click();

    }

    public void checkUsername(String name, String lastname) {
        WebElement checkUserName = drive.findElement(userName);
        Assert.assertEquals(name + " " + lastname, checkUserName.getText());

    }

    public void checkSignOutButton() {
        WebElement signOutElement = drive.findElement(signOutLocator);
        Assert.assertTrue(signOutElement.isDisplayed());


    }




}
