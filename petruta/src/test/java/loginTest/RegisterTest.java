package loginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.Header;
import pageobjects.Login;
import pageobjects.Register;

public class RegisterTest {
    WebDriver driver;
    Login login;
    Register register;
    Header header;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void init()  throws InterruptedException {
        header = new Header(driver);
        header.clickSingIn();
        login = new Login(driver);

        login.createAnValidAccount("mpetruta@sv.ro");
        login.clickCreateAnAccount();
        Thread.sleep(5000);
        System.out.println("after wait");
    }



    @Test
    public void createAnValidAccount() {
        register = new Register(driver);

        register.loginValidUser("Petruta", "Petruta", "Maties", "Maties", "Iasi", "Petruta123", "Iasi", 12, "0744123456", "abc", "00000");

    }

    @AfterTest
    public void SingOut() {

        driver.close();
    }

}
