package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static util.Constants.*;

public class Header {
    WebDriver driver;

    By signInLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By signOutLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
    By account = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
    By phoneLocator = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/span/strong");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInLocator).click();

    }

    public void clickSignOut() {
        driver.findElement(signOutLocator).click();

    }

    public void checkUserName(String username) {
        String name = driver.findElement(account).getText();
        Assert.assertEquals(name, username);

    }

    public void checkSignOutVisible() {
        boolean check = driver.findElement(signOutLocator).isDisplayed();
        Assert.assertTrue(check);
    }

    public void checkPhone(String phone) {

        //check if phone is visible
        boolean check = driver.findElement(phoneLocator).isDisplayed();
        Assert.assertTrue(check);

        //check if phone is correct
        String number = driver.findElement(phoneLocator).getText();
        Assert.assertEquals(number, phone);
    }

    public static void main(String[] args) {
        String pathToDriver = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(BASE_URL);

        Header header = new Header(webDriver);
        header.clickSignIn();

        Login login = new Login(webDriver);
        login.loginValidUser(EMAIL, PASSWORD);

        header.checkPhone(PHONE);
        header.checkSignOutVisible();
        header.checkUserName(USERNAME);
        header.clickSignOut();

        webDriver.close();
    }
}
