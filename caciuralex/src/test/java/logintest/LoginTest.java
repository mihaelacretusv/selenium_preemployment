package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;

import static util.Constants.*;

public class LoginTest {
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
    public void logInValidUser() {
        Header header = new Header(driver);
        Login login = new Login(driver);
        login.loginValidUser(EMAIL, PASSWORD);
        header.checkSignOutVisible();
    }

    @Test
    public void logIn_InvalidUser() {
        Login login = new Login(driver);
        login.loginInvalidUser(INVALID_EMAIL, PASSWORD);
    }

    @AfterTest
    public void signOut() {
        Header header = new Header(driver);
        header.clickSignOut();
    }

    @AfterSuite
    public void closeDriver() {
        driver.close();
    }
}
