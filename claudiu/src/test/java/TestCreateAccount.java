import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.CreateAccount;
import pageobjects.Header;
import pageobjects.Login;
import pageobjects.RegiterSecondPage;
import util.Constants;

public class TestCreateAccount {
    WebDriver webDriver;
    Header header;
    Login login;
    CreateAccount create;
    RegiterSecondPage createSecond;

    @BeforeSuite
    public void beforeSuita() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(Constants.BASE_URL);

    }

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        header=new Header(webDriver);
        header.clickSignIn();
        create=new CreateAccount(webDriver);
        create.enterEmail("iacob.claudiu1@gmail.com");
        create.clickRegister();
        Thread.sleep(5000);
        System.out.println("after wait");

    }

    @Test
    public void testFirstRegisterPage()
    {

     createSecond=new RegiterSecondPage(webDriver);

     String title=webDriver.getTitle();
     System.out.println(title);

     createSecond.insertFirstName("Claudiu");
     createSecond.insertLastName("Iacob");


    }














}
