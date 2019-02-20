package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import util.Constants;

public class LoginTest {
    private static WebDriver webDriver;
    private static Header header;

    @BeforeSuite
    public void method(){
        System.setProperty("webdriver.chrome.driver", "C:\\Flder\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void init(){
        webDriver.get(Constants.URL);
        header = new Header(webDriver);
        header.clickSignIn();
    }


    @Test(groups ={ "positivetest"})
    public void logValidUser(){
        Login login = new Login(webDriver);
        login.loginValidUser(Constants.EMAIL, Constants.PASSWORD);
    }

    @Test(groups = {"negativetest"})
    public void logInvalidUser(){
        Login login=new Login(webDriver);
        login.loginInvalidUser("email", "password");
    }


    @Test(groups = {"negativetest"})
    public void invalidPasswordLength(){

    }

    @Test(groups = {"negativetest"})
    public void invalidEmailFormat(){

    }

    @Test(groups = "negativetest")
    public void invalidPasswordFormat(){

    }

    @Test(groups = "negativetest")
    public void invalidSignInButton(){
    }


    @AfterTest
    public void signOut(){
        header.clickSignOut();
    }

    @AfterSuite
    public void suite(){
        webDriver.close();
    }


}
