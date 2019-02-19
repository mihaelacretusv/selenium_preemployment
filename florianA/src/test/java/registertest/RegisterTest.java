package registertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageobject.Header;
import pageobject.Register;


public class RegisterTest {

    WebDriver webDriver;
    Header head;
    Register register;
    By errorLocator = By.className("page-heading");

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

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorLocator)));

        register = new Register(webDriver);

        String firstName = "florian";
        String lastName = "paun";
        String email = "flo@gmail.com";
        String password = "326159487Fl";
        String firstName2 = "florian";
        String lastName2 = "paun";
        String address = "am adresa";
        String city = "Oras";
        int index = 3;
        String zip = "40070";
        int country = 21;
        String mphone = "0745356158";
        String alias = "flo@gmail.com";

        register.registerUser(firstName, lastName, email, password, firstName2, lastName2, address, city, index, zip, country, mphone, alias);

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
