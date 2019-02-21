package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

public class MainObject {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(Constants.BASE_URL);

        Header header = new Header(webDriver);
        header.clickSignIn();
        Login login = new Login(webDriver);
        login.loginValidUser(Constants.EMAIL_ADDRESS, Constants.PASSWORD);
    }
}
