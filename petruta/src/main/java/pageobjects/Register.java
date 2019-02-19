package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Register {
    private By firstNameLocator = By.xpath("//*[@id=\"customer_firstname\"]");
    private By firstNameLocator2 = By.id("firstname");
    private By lastNameLocator = By.xpath("//*[@id=\"customer_lastname\"]");
    private By lastNameLocator2 = By.id("lastname");
    private By emailRegisterLocator = By.xpath("//*[@id=\"email\"]");
    private By passwordRegisterLocator = By.xpath("//*[@id=\"passwd\"]");
    private By adrressLocotor = By.id("address1");
    private By cityLocator = By.id("city");
    private By stateLocator = By.id("id_state");
    private By zipCodeLocator = By.id("postcode");
    private By countryLocator = By.id("id_country");
    private By mobilePhoneLocator = By.id("phone_mobile");
    private By aliasLocator = By.xpath("//*[@id=\"alias\"]");
    private By registerButtonLocator = By.xpath("//*[@id=\"submitAccount\"]/span");

    WebDriver webDriver;

    public Register(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void populateFirstName(String firstName) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(firstNameLocator).click();
        webDriver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void populateLastName(String lastName) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(lastNameLocator).click();
        webDriver.findElement(lastNameLocator).sendKeys(lastName);
    }

   /* public void populateEmail(String email) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(emailRegisterLocator).click();
        webDriver.findElement(emailRegisterLocator).sendKeys(email);
    }
*/
    public void populatePassword(String password) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(passwordRegisterLocator).click();
        webDriver.findElement(passwordRegisterLocator).sendKeys(password);
    }

    public void populateSecondFirstName(String firstName2) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(firstNameLocator2).click();
        webDriver.findElement(firstNameLocator2).sendKeys(firstName2);
    }

    public void populateSecondLastName(String lastName2) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(lastNameLocator2).click();
        webDriver.findElement(lastNameLocator2).sendKeys(lastName2);
    }

    public void populateAddress(String address) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(adrressLocotor).click();
        webDriver.findElement(adrressLocotor).sendKeys(address);
    }

    public void populateCity(String city) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(cityLocator).click();
        webDriver.findElement(cityLocator).sendKeys(city);
    }

    public void populateState(int state) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select select = new Select(webDriver.findElement(stateLocator));
        select.selectByIndex(state);
    }

    public void populateZipCode(String zip) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(zipCodeLocator).click();
        webDriver.findElement(zipCodeLocator).sendKeys(zip);
    }

   /* public void populateCountry(String country) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select select = new Select(webDriver.findElement(countryLocator));
        select.deselectByVisibleText(country);

    }*/

    public void populateMobilePhone(String mobilePhone) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(mobilePhoneLocator).click();
        webDriver.findElement(mobilePhoneLocator).sendKeys(mobilePhone);
    }

    public void populateAlias(String alias) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(aliasLocator).click();
        webDriver.findElement(aliasLocator).sendKeys(alias);
    }

    public void clickRegister() {
        webDriver.findElement(registerButtonLocator).click();
    }

    public void loginValidUser(String firstName,String firstName2, String lastName,String lastName2, String address, String password,String city,int state,String mobilePhone,String alias,String zip) {
        populateFirstName(firstName);
        populateLastName(lastName);
        //populateEmail(email);
        populatePassword(password);
        populateSecondFirstName(firstName2);
        populateSecondLastName(lastName2);
        populateCity(city);
        populateState(state);
        populateMobilePhone(mobilePhone);
        populateAddress(address);
        populateAlias(alias);
        populateZipCode(zip);
       // populateCountry(country);
        clickRegister();
        Header h = new Header(webDriver);
        h.signOutButtonIsVisible();
    }


}
