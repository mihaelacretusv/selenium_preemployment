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

    @Test(priority = 1, groups ={"logInPositiveTest"})
    public void logValidUser() {
        login.loginValidUser(Constants.EMAIL, Constants.PASSWORD);
    }

    @Parameters({"emailAddress"})
    @Test(priority = 4, groups = { "logInNegativeTest"})
    public void logInInvalidUserWithValidEmailAddressButNonExistingAccount(@Optional("email@mailinator.com") String email){
        webdriver.findElement(new By.ByName("email")).clear();
        login.populateEmailField(email);
        assert "email@mailinator.com".equals(email);
    }

    @Test(groups = { "logInNegativeTest"})
    public void logInInvalidUserWithSpecialCharacters(){

    }
    @Test(groups = { "logInNegativeTest"})
    public void logInInvalidUsersWithNumerals(){
    }

    @Test(groups = { "logInNegativeTest"})
    public void logInInvalidUserWithBlankFields(){

    }

    @Test(groups = { "logInNegativeTest"})
    public void logInUserThatIsAlreadyLoggedIn(){

    }

    @Test(priority = 2, groups = {"logInPositiveTest"})
    public void signOut() {
        header.clickSignOut();
    }

    @Test(priority = 3,groups = { "logInNegativeTest"})
    public void logInvalidUser() {
        login.loginInValidUser(Constants.INVALID_EMAIL, Constants.INVALID_PASSWORD);
    }

    @AfterSuite
    public void closeBrowser() {
        webdriver.close();
    }
}
