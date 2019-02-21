package registerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.Header;
import pageobjects.Login;
import pageobjects.Register;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class RegisterTest {
    WebDriver driver;
    Login login;
    Register register;
    Header header;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }


    @BeforeTest
    public void init()  throws InterruptedException {
        header = new Header(driver);
        header.clickSingIn();
        login = new Login(driver);

        login.createAnValidAccount("ela@sv.ro");
        login.clickCreateAnAccount();
        Thread.sleep(5000);
        System.out.println("after wait");
    }



    @Test(groups = {"pozitiv"})
    public void createAnValidAccount() {
        register = new Register(driver);

        register.loginValidUser("Petruta", "Petruta", "Maties", "Maties", "Iasi", "Petruta123", "Iasi", 12, "0744123456", "abc", "00000");

    }


    @Test(groups = {"pozitiv"})
    public void completeMandatoryFields(){}


    @DataProvider(name = "information")
    public static Object[][] credentials() {
        return new Object[][] { {  "QA" }};
    }

    @Test(dataProvider = "information")
    public void completeAllFields(String  info) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"other\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"other\"]")).sendKeys(info);
    }

    @Test(groups = {"negativ"})
    public void registeredWithAlreadyExistEmailAddress(){}

    @Test(groups ={"negativ"})
    public void completeOnlyNonMandatoryFields(){}

    @Test(groups = {"negativ"})
    public void noCompletedLessOneMandatoryFields() { }


    @Test(groups = {"negativ"})
    public void invalidEmail(){
    }

    @Test(groups = {"negativ"})
    public void firstNameContainDigits(){}

    @Test(groups = {"negativ"})
    public void firstNameContainNonAlphabeticCharacters(){}
    @Test(groups = {"negativ"})
    public void lastNameContainDigits(){}
    @Test(groups = {"negativ"})
    public void lastNameContainNonAlphabeticCharacters(){}
    @Test(groups = {"negativ"})
    public void lengthPasswordContainLess5Characters(){}
    @Test(groups = {"negativ"})
    public void lengthPasswordContainMore40Characters(){}
    @Test(groups ={"negativ"})
    public void cityContainDigits(){}
    @Test(groups = {"negativ"})
    public void lengthMobilePhoneContainLess9Characters(){}
    @Test(groups = {"negativ"})
    public void lengthMobilePhoneContainMore17Characters(){}
    @Test(groups = {"negativ"})
    public void mobilePhoneContainCharacters(){}



    @AfterTest
    public void SingOut() {

        driver.close();
    }

}
