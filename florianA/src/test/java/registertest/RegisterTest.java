package registertest;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobject.Header;
import pageobject.Register;

import java.util.concurrent.TimeUnit;


public class RegisterTest {

    WebDriver webDriver;
    Header head;
    Register register;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        webDriver.get("http://automationpractice.com/index.php");
        head = new Header(webDriver);
        head.signIn();
    }

    @Test
    public void creatingAnAccountWithValidInformation() {
        WebElement element = webDriver.findElement(By.id("email_create"));
        element.sendKeys("flo@gmail.com");

        webDriver.findElement(By.id("SubmitCreate")).click();

        webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        register = new Register(webDriver);

        String firstName = "florian";
        String lastName = "paun";
        String email = "";
        String password = "326159487Fl";
        String firstName2 = "florian";
        String lastName2 = "paun";
        String address = "am adresa";
        String city = "Oras";
        int index = 3;
        String zip = "40070";
        int country = 1;
        String mphone = "0745356158";
        String alias = "flo@gmail.com";

        register.registerUser(firstName, lastName, email, password, firstName2, lastName2, address, city, index, zip, country, mphone, alias);
    }

    @Test (groups ="positive")
    public void positiveFlowWithAllFields() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithNoMandatoryFieldsCompleted() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithInvalidFormat_InThePasswordField() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithInvalidFormat_InTheAliasField() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithInvalidFormat_InTheZipCodeField() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithInvalidFormat_InTheMobilePhoneField() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithInvalidFormat_InTheDOBField() {
    }

    @Test (groups = "negative")
    public void tryToRegisterWithInvalidFormat_InTheAddressField() {
    }

    @Test (groups = "negative")
    public void seeStateFieldContent_AndChooseOneState() {
    }

    @Test (groups = "negative")
    public void seeCountryFieldContent_AndChooseOneCountry() {
    }

    @AfterTest
    public void signOut() {
        if (webDriver.findElement(head.getSignOutLocator()).isDisplayed())
            head.signOut();

    }

    @AfterSuite
    public void closeBrowser() {
        webDriver.close();
    }
}
