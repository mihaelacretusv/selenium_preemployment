package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Flder\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        Header header = new Header(webDriver);
        header.clickSignIn();
        Login login = new Login(webDriver);
        login.loginValidUser("mihaela.cretu@softvision.ro", "Test1234");
    }
}