package logintest;

import adrian.pageobject.Header;
import adrian.pageobject.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static adrian.util.Constants.*;

public class LoginTest {

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
        driver.get(BASE_URI);
        header = new Header(driver);
        header.clickSignIn();
    }


    @Test
    public void loginValidUser() {
        Login login = new Login(this.driver);
        login.loginValidUser(EMAIL, PASSWORD);
    }


    @Test
    public void loginInvalidUser() {
        Login login = new Login(this.driver);
        login.loginInvalidUser(WRONG_EMAIL, PASSWORD);
    }


    @AfterTest
    public void signOut() {
        header.clickSignOut();
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
    }
}
