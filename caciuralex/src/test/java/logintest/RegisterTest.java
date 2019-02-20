package logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.MandatoryFields;
import pageobjects.Register;

import static util.Constants.*;

public class RegisterTest {
    WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        String pathToDriver = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void initUrl() {
        driver.get(BASE_URL);
        Header header = new Header(driver);
        header.clickSignIn();
    }

    @Test(groups = {"negative"})
    public void tryToRegister_WithAlreadyUsedEmail() {
        Register register = new Register(driver);
        register.populateEmail(INVALID_EMAIL);
        register.clickCreate();
        register.checkCreateErrorVisible();
    }

    @Test(groups = {"negative"})
    public void tryToRegister_WithValidEmail_WithoutCompletingAllMandatory() {
        Register register = new Register(driver);
        register.populateEmail(EMAIL);
        register.clickCreate();
        MandatoryFields man = new MandatoryFields(driver);
        man.populateAllWithoutPassword(FIRSTNAME, LASTNAME, ADDRESS, CITY, ZIP, PHONE);
        man.clickRegister();
        man.checkMandatoryErrorVisible();

    }

    @Test(groups = {"negative"})
    public void checkIfPopulatedPasswordHasLessThan5_Characters() {
        Register register = new Register(driver);
        register.populateEmail(EMAIL);
        register.clickCreate();
        MandatoryFields man = new MandatoryFields(driver);
        man.populateAll(FIRSTNAME, LASTNAME, BADPASS, ADDRESS, CITY, ZIP, PHONE);
        man.clickRegister();
        man.checkPasswordError();
    }

    @Test(groups = {"positive"})
    public void register_WithValidEmail_CompletingAllMandatory() {
        Header header = new Header(driver);
        Register register = new Register(driver);
        register.populateEmail(EMAIL);
        register.clickCreate();
        MandatoryFields man = new MandatoryFields(driver);
        man.populateAll(FIRSTNAME, LASTNAME, PASSWORD, ADDRESS, CITY, ZIP, PHONE);
        man.clickRegister();
        header.checkSignOutVisible();
    }

    @AfterSuite
    public void closeDriver() {
        driver.close();
    }
}
