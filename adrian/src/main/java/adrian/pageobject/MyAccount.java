package adrian.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {

    public WebDriver driver;
    By signInActive = By.className("login");
    By signOutActive = By.className("logout");

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void isLogged() {
        driver.findElement(signInActive).isDisplayed();
    }

    public void isntLogged() {
        driver.findElement(signOutActive).isDisplayed();
    }
}
