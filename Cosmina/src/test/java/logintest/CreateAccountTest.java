package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Register;
import pageobjects.Header;
import pageobjects.CreateAccount;
import util.Constants;

public class CreateAccountTest {

    CreateAccount account;
    WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void initial() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void createValidAccount() {

        CreateAccount account = new CreateAccount(webDriver);
        account.validCreate("testabcd@something.com");
    }


    @AfterTest
    public void exit() {
        webDriver.close();
    }

}
