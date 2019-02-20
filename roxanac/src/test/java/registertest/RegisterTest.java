package registertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import util.Constants;

public class RegisterTest {
    WebDriver driver;
    Header header;

    @BeforeSuite
    public void initial(){
        System.setProperty("webdriver.chrome.driver","C://selenium//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void init(){

        driver.get(Constants.BASE_URL);
        header = new Header(driver);
        driver.manage().window().maximize();
        header.clickSignIn();
    }


    @Test(groups = {"happyFlow"})
    public void registerWithValidEmailAddress_happyFlow(){

    }

    @Test(groups = {"negative"})
    public void registerWithAnUsedEmailAddress_negativeTest(){

    }

    @Test(groups = {"happyFlow"})
    public void completeAllTheMandatoryFieldWithValidData_happyFlow(){

    }

    @Test(groups = {"negative"})
    public void leaveAMandatoryFieldEmpty_negativeTest(){

    }

    @Test(groups = {"happyFlow"})
    public void insertSixCharactersForPassword(){

    }

    @Test(groups = {"negative"})
    public void insertLessThenFiveCharactersForPassword(){

    }

    @Test(groups = {"negative"})
    public void insertAnInvalidPhoneNumber(){

    }

    @Test(groups = {"negative"})
    public void insertAnInvalidPostalCode(){

    }

    @Test(groups = {"negative"})
    public void insertNumeralsInFirstNameField(){

    }

    @Test(groups = {"negative"})
    public void insertNumeralsInLastNameField(){

    }

    @Test(groups = {"happyFlow"})
    public void createAccount_happyFlow(){

    }

    @Test(groups = {"negative"})
    public void createAccount_negativeTest(){

    }


    @AfterTest
    public void signOut(){
        //Thread.sleep(30);
        header.clickSignOut();
    }

    @AfterSuite
    public void closeWebDriver()
    {
        driver.close();
    }

}
