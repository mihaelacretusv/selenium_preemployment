package loginTests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Header;
import pageobjects.Login;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
    private static WebDriver driver;
    private static Header header;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\01_Softvision\\Pre employment\\chromedriver.exe");
        driver = new ChromeDriver();
        header = new Header(driver);
    }

    @Before
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

    @Ignore
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
    @After
    public void signout() {
        Header header = new Header(driver);
        header.signOut();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
