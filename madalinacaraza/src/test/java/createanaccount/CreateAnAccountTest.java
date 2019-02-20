package createanaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.CreateAnAccount;

public class CreateAnAccountTest {
    private static WebDriver webDriver;
    private static CreateAnAccount account;

    @BeforeSuite
    public void method() {
        System.setProperty("webdriver.chrome.driver", "C:\\Flder\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    @Test
    public void registerValidUser(){
        CreateAnAccount account = new CreateAnAccount(webDriver);
        account.createAccount("madalina@soft.com");
    }


    @AfterTest
    public void signOut(){
       webDriver.close();

    }

}