package logintest;

import adrian.pageobject.CreateAnAccount;
import adrian.pageobject.Header;
import adrian.pageobject.Login;
import adrian.pageobject.RegisterComplete;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static adrian.util.Constants.*;

public class RegisterTest {

    WebDriver driver;
    private Header header;

    @BeforeSuite
    public void bef() {
        String pathToDriver = "..\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();

    }

    @BeforeTest
    public void init() {
        // ONLY FOR TEST
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }

    @Test
    public void registerUser() {
        CreateAnAccount create = new CreateAnAccount(this.driver);
        create.populateEmailFieldWithCorrectlyValue(REGISTER_EMAIL);
        RegisterComplete regis = new RegisterComplete(driver);
        regis.populatePIFirstName("Andrei");
        regis.populatePILastName("Popescu");
        regis.populatePass("myPAssword?!?dsa");
        //TO BE CONTINUED
    }
}
