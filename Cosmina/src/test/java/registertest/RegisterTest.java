package registertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.*;
import util.Constants;

import java.io.File;
import java.io.IOException;

public class RegisterTest {

    Header header;
    CreateAccount createAccount;
    Register register;
    WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void initial() {
        webDriver.get(Constants.BASE_URL);
        header = new Header(webDriver);
        header.clickSignIn();
        createAccount = new CreateAccount(webDriver);
        createAccount.validCreate("dfuvrihnigmvn@test.com");
    }

    @Test(groups = {"positivetest"})
    public void registerValidUser() {
        User user = null;

        Register register = new Register(webDriver);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            user = objectMapper.readValue(new File("C:\\SeleniumProject\\selenium_preemployment\\Cosmina\\src\\main\\resources\\User.json"),User.class);
            System.out.println("Address" + user.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
        register.registerUser(user);
        
    }


    @Test(groups = {"negativetest"})
    public void insertLessThanFiveCharactersForPassword() {
        
    }

    @Test(groups = {"negativetest"})
    public void typeOnlyNumbersOnFirstNameFields() {

    }

    @Test(groups = {"negativetest"})
    public void leaveAMandatoryFieldEmpty() {

    }

    @Test(groups = {"negativetest"})
    public void typeOnlyLettersOnMobilePhoneField() {

    }

    @Test(groups = {"negativetest"})
    public void checkTheErrorMessagesForEmptyFields() {

    }


    @AfterTest
    public void exit() {
        webDriver.close();
    }


}