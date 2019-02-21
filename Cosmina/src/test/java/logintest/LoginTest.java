package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import util.Constants;

import static java.lang.Thread.*;

public class LoginTest {
    Header header;
    WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void initial() {
        webDriver.get(Constants.BASE_URL);
        header = new Header(webDriver);
        header.clickSignIn();
    }

    @Test(groups = {"positivetest"})
    public void loginValidUser() {

        Login login = new Login(webDriver);
        login.loginValidUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        header.checkUserName(Constants.FIRST_NAME, Constants.LAST_NAME);

    }

    @Test(groups = {"negativetest"})
    public void loginInvalidUser() {

        Login login = new Login(webDriver);
        login.loginInvalidUser("test@test.com", "djfk");

    }



    @AfterTest
    public void signOut() {
        header.clickSignOut();

    }

    @AfterSuite
    public void exit() {
        webDriver.close();
    }
}
