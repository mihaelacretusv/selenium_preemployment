package logintest;

import adrian.pageobject.CreateAnAccount;
import adrian.pageobject.Header;
import adrian.pageobject.Login;
import adrian.pageobject.RegisterComplete;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static adrian.util.Constants.*;

public class RegisterTest {

    WebDriver driver;
    private Header header;
    private RegisterComplete regis;

    @BeforeSuite
    public void bef() {
        String pathToDriver = "..\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        driver.get(BASE_URI);
        header = new Header(driver);
        header.clickSignIn();
        CreateAnAccount create = new CreateAnAccount(this.driver);
        create.populateEmailFieldWithCorrectlyValue(REGISTER_EMAIL);
    }


    @DataProvider(name = "test1", parallel = true)
    public Object[][] createData1() {
        return new Object[][]{
                {"Alexandru", "Boss", "pass1234", "4", "5", "1999", "Street, 100 Box", "Iasi", "5", "10000", "0740120012", "Strret Zamca"},
                {"Vasile", "Mihaita", "hahalelladsaorwq", "7", "7", "2001", "Street, 22231 D", "Bacau", "7", "10001", "825442587", "Strret IaaaSssadsa"},

        };
    }

    @Test(dataProvider = "test1")
    public void registerUserWithAllMandatoryFieldsCorrectly(String firstname, String lastname, String password, String day, String month, String year, String adress, String city, String state, String postalcode, String phone, String adressalias) {
        regis = new RegisterComplete(driver);
        regis.createNewAccountWithRegisterButton();
        regis.registerUserWithAllMandatoryCompletedCorrectly(firstname, lastname, password, day, month, year, adress, city, state, postalcode, phone, adressalias);

    }

    @Test
    public void registerUserWithInvalidFirstName() {
        regis = new RegisterComplete(driver);
        regis.registerUserWithAllMandatoryCompletedCorrectly("@#$%#DAS", LAST_NAME_CORECT, PASSWORD_CORECT, DAY_CORECT, MONTH_CORECT, YEAR_CORECT, ADRESS_CORECT, CITY_CORECT, STATE_CORECT, POSTAL_CODE_CORECT, PHONE_CORECT, ALIAS_CORECT);
        regis.createNewAccountWithRegisterButton();
    }


    @AfterTest
    public void clickSignOut() {
        header.clickSignOut();
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
    }
}
