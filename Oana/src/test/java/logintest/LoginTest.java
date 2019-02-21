package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import pageobjects.util.Constants;


public class LoginTest {
    Header header;
    WebDriver webDriver;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\selenium_preemployment\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
    }

    @BeforeTest
    public void initial() {
        webDriver.get(Constants.BASE_URL);
        header = new Header(webDriver);
        header.clickSignIn();
    }


        @Test(groups={"positivetest"})
        public void loginValidUser () {

        Login login = new Login(webDriver);
        login.logInValidUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
        header.checkUserName(Constants.FIRST_NAME, Constants.LAST_NAME);

    }

        public void validPasswordLength () {

    }
        public void validEmailFormat () {

    }
        public void validPasswordFormat () {

    }

        public void validSignInButton () {


        @Test(groups={"negativetest"})

        public void loginInvalidUser() {

            Login login = new Login(webDriver);
            login.logInValidUser("test@test.com", "djfk");

        }
        public void invalidEmailFormat(){

        }
        public void invalidPasswordLength(){

        }
        public void invalidPasswordFormat(){

        }
        public void invalidSignInButton(){

        }
    }


    @Test
    public class Test2 {
        @Test(groups = {"formattest"})

        public void validEmailFormat () {

        }
        public void validPasswordFormat () {

        }
        public void invalidEmailFormat(){

        }
        public void invalidPasswordFormat(){

        }
    }


    @AfterTest
    public void signOut(){
        header.clickSignOut();
    }

    @AfterSuite
    public void closeWebDriver(){
        webDriver.close();
    }
}
