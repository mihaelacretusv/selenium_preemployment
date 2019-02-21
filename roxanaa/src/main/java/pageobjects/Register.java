package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    WebDriver webDriver;
    public Register(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By firstNameLocator = new By.ById("customer_firstname");
    By lastNameLocator = new By.ById("customer_lastname");
    By emailLocator = new By.ById("email");
    By passwordAccountLocator = new By.ById("passwd");
    By addressFirstNameLocator = new By.ById("firstname");
    By addressLastNameLocator = new By.ById("lastname");
    By addressLocator = new By.ById("address1");
    By cityLocator = new By.ById("city");
    By dropdownStateLocator = new By.ById("id_state");
    By postalCodeLocator = new By.ById("postcode");
    By countryLocator = new By.ById("id_country");
    By mobileLocator = new By.ByCssSelector("#phone_mobile");
    By aliasAddressLocator = new By.ById("alias");
    By registerLocator = new By.ById("submitAccount");

    public void firstNamePopulate(String firstName) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator));
        webDriver.findElement(firstNameLocator).click();

        WebElement element = webDriver.findElement(firstNameLocator);
        element.sendKeys(firstName);
    }

    public void lastNamePopulate(String lastName) {
        WebElement element = webDriver.findElement(lastNameLocator);
        element.sendKeys(lastName);
    }

    public void emailPopulate(String email) {
        WebElement element = webDriver.findElement(emailLocator);
        element.sendKeys(email);
    }

    public void passwordPopulate(String password) {
        WebElement element = webDriver.findElement(passwordAccountLocator);
        element.sendKeys(password);
    }

    public void addressFirstNamePopulate(String addressFirstName) {
        WebElement element = webDriver.findElement(addressFirstNameLocator);
        element.sendKeys(addressFirstName);
    }

    public void addressLastNamePopulate(String addressLastName) {
        WebElement element = webDriver.findElement(addressLastNameLocator);
        element.sendKeys(addressLastName);
    }

    public void addressPopulate(String address) {
        WebElement element = webDriver.findElement(addressLocator);
        element.sendKeys(address);
    }

    public void cityPopulate(String city) {
        WebElement element = webDriver.findElement(cityLocator);
        element.sendKeys(city);
    }

    public void dropdownStatePopulate(String value) {
        Select element = new Select(webDriver.findElement(dropdownStateLocator));
        element.selectByValue(value);
    }

    public void postalCodePopulate(String postalCode) {
        WebElement element = webDriver.findElement(postalCodeLocator);
        element.sendKeys(postalCode);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileLocator));
        webDriver.findElement(mobileLocator).click();
    }
    public void mobilePopulate(String mobile) {
        WebElement element = webDriver.findElement(mobileLocator);
        element.sendKeys(mobile);
    }

    public void dropdownCountryPopulate(String value) {
        Select element = new Select(webDriver.findElement(countryLocator));
        element.selectByValue(value);
    }

    public void addressAliasPopulate(String aliasAddress) {
        WebElement element = webDriver.findElement(aliasAddressLocator);
        element.clear();
        element.sendKeys(aliasAddress);
    }

    public void clickRegister() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerLocator));
        webDriver.findElement(registerLocator).click();
    }

}
