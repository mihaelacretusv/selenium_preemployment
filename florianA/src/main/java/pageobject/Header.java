package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Header {
    By signInLocator = By.className("login");
    By signOutLocator = By.className("logout");

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public By getSignOutLocator() {
        return signOutLocator;
    }

    public void signIn() {
        driver.findElement(signInLocator).click();
    }


    public void signOut() {
        driver.findElement(signOutLocator).click();
    }

    public void checkUserName(String firstName, String lastName) {
        String name = driver.findElement(By.xpath("//div[@class=\"header_user_info\"]/a[@class=\"account\"]/span")).getText();

        String[] splited = name.split(" ");
        Assert.assertEquals(splited[0], firstName);
        Assert.assertEquals(splited[1], lastName);
    }


}
