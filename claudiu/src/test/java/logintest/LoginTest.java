package logintest;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import util.Constants;


public class LoginTest {
    WebDriver webDriver;
    Header header;
    Login login;

    @BeforeSuite
    public void BeforeSuita() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();

    }


    @BeforeTest
    public void BeforeTest() {
        webDriver.get(Constants.BASE_URL);
        header=new Header(webDriver);
        header.clickSignIn();
    }
    @Parameters({"b", "c"})
    @Test(groups = "positive")
    public void testLogin( String b,  String c) {
        Login login = new Login(webDriver);
        login.clickemailAdress();
        login.populateEmailAdress(b);
        login.clickpassword();
        login.populatepassword(c);
        login.clickSignInClick();


    }

    @Test()
    public void validUser() {

        Login login = new Login(webDriver);
        login.clickemailAdress();
        login.populateEmailAdress(Constants.USERNAME);
        login.clickpassword();
        login.populatepassword(Constants.PASSWORD);
        login.clickSignInClick();
        header.checkUsername("Mihaela", "Cretu");
    }


    @Ignore
    public  void invalid()
    {
        login=new Login(webDriver);
        login.InvalidUser();

    }


    @Test(groups = "negative")
    public void tryToLoginWithWrongEmailAndPassword() {


    }

    @Test(groups = "negative")
    public void tryToLoginWithOnlyEmail() {


    }


    @Test(groups = "negative")
    public void tryToLoginWithNoPassword() {

    }

    @Test(groups = "negative")
    public void tryToLoginWithNoEmailAdress() {


    }

    @Test(groups = "positive")
    public void verifyLogInWithSucces() {

    }

    @Test(groups = "positive")
    public void verifyLogOutWithSucces() {

    }

    @Test(groups = "negative")
    public void checkInvalidUserLogIn() {


    }


}
