package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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


    @Test
    public void validUser() {

        Login login = new Login(webDriver);
        login.clickemailAdress();
        login.populateEmailAdress(Constants.USERNAME);
        login.clickpassword();
        login.populatepassword(Constants.PASSWORD);
        login.clickSignInClick();
        header.checkUsername("Mihaela","Cretu");
    }

    @Test
    public  void invalid()
    {
        login=new Login(webDriver);
        login.InvalidUser();

    }
    @AfterTest
    public void Signout()

    {
        header=new Header(webDriver);
        header.clickSignOut();

    }












}
