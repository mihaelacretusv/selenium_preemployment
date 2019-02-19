package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

public class PageObjectsMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(Constants.BASE_URL);

        Header header = new Header(webDriver);
        header.clickSignIn();

        Login login = new Login(webDriver);
        login.populateEmailField(Constants.EMAIL);
        login.populatePasswordField(Constants.PASSWORD);
        login.clickSignInButton();

        MyAccount account = new MyAccount(webDriver);
        account.CheckMyAccountText();
    }
}
