package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static util.Constants.*;


public class Main {
    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://selenium//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        Header header = new Header(driver);
        header.clickSignIn();
        Register register = new Register(driver);
        register.insertValidEmailAddress(UNUSED_EMAIL_ADDRESS);
        RegisterForm registerFrom = new RegisterForm(driver);
        registerFrom.registerValidInput("Maria","Pop", "pop.an@gmail.com", "parola", "Maria", "Pop","ceva", "Iasi", "Texas", "000)00", "United States", "0123456","altceva");

    }
    }

