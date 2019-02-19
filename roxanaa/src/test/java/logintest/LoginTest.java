package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import util.Constants;

public class LoginTest {
    private static WebDriver webdriver;
    private static Login login;
    private static Header header;

    @BeforeSuite()
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        webdriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        webdriver.get(Constants.BASE_URL);
        webdriver.manage().window().maximize();
        header = new Header(webdriver);
        header.clickSignIn();
        login = new Login(webdriver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void logValidUser() {
        login.loginValidUser(Constants.EMAIL, Constants.PASSWORD);
    }

    @Test(priority = 2)
    public void signOut() {
        header.clickSignOut();
    }

    @Test(priority = 3)
    public void logInvalidUser() {
        login.loginInValidUser(Constants.INVALID_EMAIL, Constants.INVALID_PASSWORD);
    }


    @AfterSuite
    public void closeBrowser() {
        webdriver.close();
    }
}
