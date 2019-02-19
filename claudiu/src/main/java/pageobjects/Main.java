package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

public class Main {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(Constants.BASE_URL);
        Header header = new Header(webDriver);
        header.clickSignIn();
        Login login = new Login(webDriver);
        login.clickemailAdress();
        login.populateEmailAdress(Constants.USERNAME);
        login.clickpassword();
        login.populatepassword(Constants.PASSWORD);
        login.clickSignInClick();
        header.checkUsername("Mihaela", "Cretu");
        login.loginValidUser(Constants.USERNAME,Constants.PASSWORD);
        header.clickSignOut();
        login.InvalidUser();
        webDriver.close();

    }
}
