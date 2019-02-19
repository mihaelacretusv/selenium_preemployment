package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {
    WebDriver driver;

    By titleNocator;
    By firstNameLocator = By.id("customer_firstname");
    By lastNameLocator = By.id("customer_lastname");
    By emailLocator = By.id("email");
    By passwordLocator= By.id("passwd");
    By dobLocator;

    By firstNameLocator2 = By.id("firstname");
    By lastNameLocator2 = By.id("lastname");

    By addressLocator = By.id("address1");

    By cityLocator = By.id("city");
    Select stateLocator = new Select(driver.findElement(By.id("id_state")));
    By zipLocator = By.id("postcode");
    Select countryLocator = new Select(driver.findElement(By.id("id_country")));


    By mobilePhoneLocator = By.id("phone_mobile");
    By aliasLocator = By.id("alias");
    By registerButtonLocator = By.id("submitAccount");



    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void populateFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void populateLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void populateEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void populatePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void populateFirstName2(String firstName) {
        driver.findElement(firstNameLocator2).sendKeys(firstName);
    }

    public void populateLastName2(String lastName) {
        driver.findElement(lastNameLocator2).sendKeys(lastName);
    }

    public void populateAddress(String address) {
        driver.findElement(addressLocator).sendKeys(address);
    }

    public void populateCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void populateState(int index) {
        stateLocator.selectByIndex(index);
    }

    public void populateZip(String zip) {
        driver.findElement(zipLocator).sendKeys(zip);
    }

    public void populateCountry(int index) {
        countryLocator.selectByIndex(index);
    }

    public void populateMobilePhone(String mobilePhone) {
        driver.findElement(mobilePhoneLocator).sendKeys(mobilePhone);
    }

    public void populateAlias(String alias) {
        driver.findElement(aliasLocator).sendKeys(alias);
    }

    public void pressRegister() {
        driver.findElement(registerButtonLocator).click();
    }

    public void registerUser(String firstName, String lastName, String email, String password, String firstName2, String lastName2, String address, String city,int state, String zip, int country, String mphone, String alias) {
        populateFirstName(firstName);
        populateLastName(lastName);
        populateEmail(email);
        populatePassword(password);
        populateFirstName2(firstName2);
        populateLastName2(lastName2);
        populateAddress(address);
        populateCity(city);
        populateState(state);
        populateZip(zip);
        populateCountry(country);
        populateMobilePhone(mphone);
        populateAlias(alias);
        pressRegister();

    }

}
