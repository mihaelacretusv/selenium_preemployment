package logintest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobject.Header;
import pageobject.Login;

public class LoginTest {

    WebDriver webDriver;
    Header head;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        webDriver.get("http://automationpractice.com/index.php");
        head = new Header(webDriver);
        head.signIn();
    }

    @Test
    public void loginPositive() {
        Login login = new Login(webDriver);
        String testEmail = "mihaela.cretu@softvision.ro";
        String testPassword = "Test1234";
        login.loginValidUser(testEmail, testPassword);
        head.checkUserName("Mihaela","Cretu");

    }

    @Test
    public void loginNegative() {
        Login login = new Login(webDriver);
        String testEmail = "email@email.com";
        String testPassword = "pass";
        login.loginInvalidUser(testEmail, testPassword);
    }

    @AfterTest
    public void signOut() {
        if (webDriver.findElement(head.getSignOutLocator()).isDisplayed())
            head.signOut();

    }

    @AfterSuite
    public void closeBrowser() {
        webDriver.close();
    }
}
