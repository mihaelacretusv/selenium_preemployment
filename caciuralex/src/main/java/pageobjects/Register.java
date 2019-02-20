package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static util.Constants.*;

public class Register {
    WebDriver driver;
    By email = By.id("email_create");
    By create = By.id("SubmitCreate");
    By error=By.id("create_account_error");


    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void populateEmail(String address) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(address);
    }

    public void clickCreate() {
        driver.findElement(create).click();
    }

    public void checkCreateErrorVisible() {
        driver.findElement(error).isDisplayed();
    }

    public static void main(String[] args) {
        String pathToDriver = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(BASE_URL);

        Header header = new Header(webDriver);
        header.clickSignIn();
        Register register = new Register(webDriver);
        register.populateEmail(INVALID_EMAIL);
        register.clickCreate();

        MandatoryFields man = new MandatoryFields(webDriver);
        man.populateAll(FIRSTNAME, LASTNAME, PASSWORD, ADDRESS, CITY, ZIP, PHONE);

        webDriver.close();
    }


}
