package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageobjects.Header;
import pageobjects.Login;

public class LoginTest {
    Header header;
    WebDriver webDriver;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\selenium_preemployment\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
    }

    @BeforeTest



    @AfterTest
    public void signOut(){
        header.clickSignOut();
    }
    @AfterSuite
    public void closeWebDriver(){
        webDriver.close();
    }
}
