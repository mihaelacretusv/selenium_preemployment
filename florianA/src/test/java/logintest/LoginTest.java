package logintest;

import com.beust.jcommander.Parameter;
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

    @Parameters()
    @Test (groups = "positive")
    public void loginPositive() {
        Login login = new Login(webDriver);
        String testEmail = "mihaela.cretu@softvision.ro";
        String testPassword = "Test1234";
        login.loginValidUser(testEmail, testPassword);
        head.checkUserName("Mihaela","Cretu");

    }

    @Test (groups = "negative")
    public void loginNegative() {
        Login login = new Login(webDriver);
        String testEmail = "email@email.com";
        String testPassword = "pass";
        login.loginInvalidUser(testEmail, testPassword);
    }


    @Test (groups = "negative")
    public void tryCreatingAnAccountWithExistingEmailAddress() {
    }

    @Test (groups = "negative")
    public void tryToLoginWithAnExistingEmailAddressButWrongPassword() {
    }


    @Test (groups = "negative")
    public void tryToLoginWithSQLInjectionInTheEmailAddressField() {
    }


    @Test (groups = "negative")
    public void tryToLoginWithSQLInjectionInThePasswordField() {
    }

    @Test
    public void testForgetYourPasswordButton() {
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
