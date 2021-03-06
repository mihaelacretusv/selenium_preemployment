package createaccounttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobjects.CreateAccount;
import pageobjects.Header;
import pageobjects.Login;
import pageobjects.Register;
import util.Constants;

public class RegisterTest {
    private static WebDriver webdriver;
    private static Login login;
    private static Header header;
    private static CreateAccount account;

    @BeforeSuite()
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        webdriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        webdriver.get(Constants.BASE_URL);
        webdriver.manage().window().maximize();
        header = new Header(webdriver);
        header.clickSignIn();
        login = new Login(webdriver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = { "positiveTest"})
    public void validCreateAccount(){
        CreateAccount account = new CreateAccount(webdriver);
        account.accountEmailField("roxana111oj1@mailinator.com");
        account.clickCreateAccount();

        Register personal = new Register(webdriver);
        personal.firstNamePopulate("Ema");
        personal.lastNamePopulate("Popescu");
        personal.passwordPopulate("Parola1234");
        personal.addressFirstNamePopulate("Ema");
        personal.addressLastNamePopulate("Popescu");
        personal.addressPopulate("Srada Street, P.O. Box 23, Company name: Softvision");
        personal.cityPopulate("Iasi");
        personal.dropdownStatePopulate("1");
        personal.postalCodePopulate("00000");

        personal.mobilePopulate("0745700900");
        personal.addressAliasPopulate("Strada");
        personal.dropdownCountryPopulate("21");
        personal.clickRegister();
    }

    @Test(groups = { "positiveTest"})
    public void createAccountWithAllFieldsCompleted(){

    }
    @Test(groups = { "positiveTest"})
    public void validCheckOneTitleRadioButton(){
    }
    @Test(groups = { "negativeTest"})
    public void invalidCreateAccountWithAlreadyUsedEmailAddress(){
    }

    @Test(groups = { "negativeTest"})
    public void createAccountWithNumeralsInAllFields(){
    }
    @Test(groups = { "negativeTest"})
    public void createAccountWithAllFieldsBlank(){

    }
    @Test(groups = { "negativeTest"})
    public void createAccountWithSpecialCharactersInAllFields(){
    }
    @Test(groups = { "negativeTest"})
    public void createAccountWithALargeNumberOfCharacters(){

    }
    @Test(groups = { "negativeTest"})
    public void createAccountWithInvalidEmailFormat(){
    }
    @Test(groups = { "negativeTest"})
    public void invalidCheckBothTitleRadioButtons(){
    }
    @Test(groups = { "negativeTest"})
    public void createAccountWithPasswordLessThanFiveCharacters(){

    }
    @Test(groups = { "negativeTest"})
    public void createAccountFillingOnlyTheNotMandatoryFields(){
    }
    @Test(groups = { "redundantTest"})
    public void checkCreateAccountButtonCanBeClicked(){
    }
    @Test(groups = { "redundantTest"})
    public void  createAccountWithoutSelectingFromCountryDropdown(){

    }
    @Test(groups = { "redundantTest"})
    public void createAccountWithoutSelectingFromStateDropdown(){
    }
    @Test(groups = { "redundantTest"})
    public void checkIfRegisterButtonIsVisible(){
    }
    @Test(groups = { "redundantTest"})
    public void checkIfYouCanPressRegisterButton(){
    }


    @AfterSuite
    public void closeBrowser() {
        webdriver.close();
    }

}
