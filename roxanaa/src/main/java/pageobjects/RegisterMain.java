package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

public class RegisterMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(Constants.BASE_URL);

        Header header = new Header(webDriver);
        header.clickSignIn();

        CreateAccount account = new CreateAccount(webDriver);
        account.accountEmailField("roxana11@mailinator.com");
        account.clickCreateAccount();

        Register personal = new Register(webDriver);
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
}
