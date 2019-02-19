package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.MandatoryFields;
import pageobjects.Register;

import static util.Constants.*;

public class RegisterTest {
    WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        String pathToDriver = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void initUrl() {
        driver.get(BASE_URL);
        Header header = new Header(driver);
        header.clickSignIn();
    }

    @Test
    public void registerValidUser(){
        Header header = new Header(driver);
        Register register = new Register(driver);
        register.populateEmail(EMAIL);
        register.clickCreate();
        MandatoryFields man=new MandatoryFields(driver);
        man.populateAll(FIRSTNAME, LASTNAME, PASSWORD, ADDRESS, CITY, ZIP, PHONE);
        header.checkSignOutVisible();
    }

    @AfterSuite
    public void closeDriver() {
        driver.close();
    }
}
