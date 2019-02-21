package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.util.Constants;

public class MainObject {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium_preemployment\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        webDriver.get(Constants.BASE_URL);

        Header header = new Header(webDriver);
        header.clickSignIn();
        Login login = new Login(webDriver);
        login.logInValidUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);

    }
}
