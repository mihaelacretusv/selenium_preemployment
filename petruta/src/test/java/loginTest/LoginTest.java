package loginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;

public class LoginTest {
    Header header;
    Login login;
    WebDriver webDriver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }


    @BeforeTest
    public void init() {

        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
        header = new Header(webDriver);
        header.clickSingIn();
    }


    @Test
    public void logValidUser() {

        login = new Login(webDriver);
        login.loginValidUser("mihaela.cretu@softvision.ro", "Test1234");
        header.checkUserName("Mihaela", "Cretu");
    }

    @Test
    public void loginNegative() {
        login = new Login(webDriver);
        login.loginInvalidUser("ceva@ceva.ceva","password");
    }



    @AfterTest
    public void SingOut() {

        header.clickSingOut();
    }

    @AfterSuite
    public void closeWebDriver() {
        webDriver.close();
    }



}
