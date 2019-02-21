package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import util.Constants;

public class LoginTest {
    WebDriver driver;
    Header header;
    @DataProvider(name = "login")
    public static Object[][] login(){
        return new Object[][]{{"mihaela.cretu@softvision.com", "Test1234"}, {"mihaela.cretu@softvision.ro", "Test1234"}};
    }
    @BeforeSuite
    public void initial(){
        System.setProperty("webdriver.chrome.driver","C://selenium//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void init(){

        driver.get(Constants.BASE_URL);
        header = new Header(driver);
        driver.manage().window().maximize();
        header.clickSignIn();

    }

    @Test(groups = {"positive"})
    public void login_ValidUser_ShouldRedirectToMyAccount(){

        Login login = new Login(driver);

        //Act
        login.loginValidUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        header.checkUsername(Constants.FIRST_NAME, Constants.LAST_NAME);
        //Assert
        header.signInVisibleButton();
    }

    @Test(groups = {"negative"})
    public void login_InvalidUser_ShouldNotRedirectToMyAccount(){
        Login login = new Login(driver);
        login.loginInvalidUser(Constants.INVALID_EMAIL_ADDRESS, Constants.PASSWORD);

    }

    @Test(dataProvider = "login")
    public void loginValidUser(String email, String password)
    {
        System.out.println(email + " " + password);
    }


    @AfterTest
    public void signOut(){
     header.clickSignOut();
    }

    @AfterSuite
    public void closeWebDriver()
    {
        driver.close();
    }
}
