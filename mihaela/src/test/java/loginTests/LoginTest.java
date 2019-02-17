package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;

public class LoginTest {
    private static WebDriver driver;
    private static Header header;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\01_Softvision\\Pre employment\\chromedriver.exe");
        driver = new ChromeDriver();
        header = new Header(driver);
    }

    @BeforeTest
    public void initial() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        Header header = new Header(driver);
        header.signIn();
    }

    @Test
    public void loginWithSuccess() {
        Login loginPage = new Login(driver);
        loginPage.loginWith("johnsnow@workshop.com", "iknoweverything");
        header.checkUserLogged("John Snow");

    }

    @Test
    public void loginWithSuccess2() {
        Login loginPage = new Login(driver);
        loginPage.loginWith("johnsnow@workshop.com", "iknoweverything0");

    }


    @Test
    public void loginWithSuccess3() {
        Login loginPage = new Login(driver);
        loginPage.loginWith("johnsnow@workshop.com", "iknoweverything0");

    }
    @AfterTest
    public void signout() {
        Header header = new Header(driver);
        header.signOut();
    }

    @AfterSuite
    public static void tearDown() {
        driver.close();
    }
}
