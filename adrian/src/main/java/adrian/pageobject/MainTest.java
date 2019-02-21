package adrian.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static adrian.util.Constants.*;

public class MainTest {

    public static void main(String[] args) {
        String pathToDriver = "..\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        WebDriver webDriver = new ChromeDriver();

        webDriver.get(BASE_URI);

        Header header = new Header(webDriver);
        header.clickSignIn();

        Login login = new Login(webDriver);
        login.loginValidUser(EMAIL,PASSWORD);

        header.checkUserName(USER_NAME);
        header.clickSignOut();

        webDriver.close();

    }
}
