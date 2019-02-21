package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterForm {
    By firstNameLocator = By.name("customer_firstname");
    By lastNameLocator = By.name("customer_lastname");
    By emailLocator = By.name("email");
    By passwordLocator = By.name("passwd");
    By firstNameYourAddressLocator = By.name("firstname");
    By lastNameYourAddressLocator = By.name("lastname");
    By addressLocator = By.name("address1");
    By cityLocator = By.name("city");
    By stateLocator = By.name("id_state");
    By postalCodeLocator = By.name("postcode");
    By countryLocator = By.name("id_country");
    By phoneLocator = By.name("phone_mobile");
    By addressAliasLocator = By.name("alias");
    By registerLocator = By.partialLinkText("Register");

    WebDriver driver;
    WebElement element;

    public RegisterForm(WebDriver driver) {
        this.driver = driver;
    }


    public void verifyPasswordCondition(String password){
        Assert.assertTrue(password.length()>=5);
    }

    public void populateFirstNameField(String firstName){
        element = driver.findElement(firstNameLocator);
        element.clear();
        element.sendKeys(firstName);

        }
    public void populateLastNameField(String lastName){
        element = driver.findElement(lastNameLocator);
        element.clear();
        element.sendKeys(lastName);
    }
    public void populateEmailAddressField(String email){
        element = driver.findElement(emailLocator);
        element.clear();
        element.sendKeys(email);
    }

    public void populatePasswordField(String password){
        verifyPasswordCondition(password);
        element = driver.findElement(passwordLocator);
        element.clear();
        element.sendKeys(password);
    }

    public void populateFirstNameYourAddressField(String firstNameYourAddress){
        element = driver.findElement(firstNameYourAddressLocator);
        element.clear();
        element.sendKeys(firstNameYourAddress);
    }

    public void populateLastNameYourAddressField(String lastNameYourAddress){
        element = driver.findElement(lastNameYourAddressLocator);
        element.clear();
        element.sendKeys(lastNameYourAddress);
    }

    public void populateAddressField(String address){
        element = driver.findElement(addressLocator);
        element.clear();
        element.sendKeys(address);
    }

    public void populateCityField(String city){
        element = driver.findElement(cityLocator);
        element.clear();
        element.sendKeys(city);
    }

    public void populateStateField(String state){
        Select dropdownState = new Select(driver.findElement(stateLocator));
        dropdownState.selectByVisibleText(state);
    }

    public void populatePostalCodeField(String postcode){
        element = driver.findElement(postalCodeLocator);
        element.clear();
        element.sendKeys(postcode);
    }

    public void populateCountryField(String country){
        Select drpCountry = new Select(driver.findElement(countryLocator));
        drpCountry.selectByVisibleText(country);
    }

    public void populateMobilePhoneField(String phone){
        element = driver.findElement(phoneLocator);
        element.clear();
        element.sendKeys(phone);
    }

    public void populateAddressAliasField(String aliasAddress){
        element = driver.findElement(addressAliasLocator);
        element.clear();
        element.sendKeys(aliasAddress);
    }

    public void clickRegister(){
        element.findElement(registerLocator).click();
    }

    public void registerValidInput(String firstname, String lastname, String email, String password, String firstnameaddress, String lastnameaddress, String address, String city, String state, String postalcode, String country, String phone, String aliasaddress)
    {
        populateFirstNameField(firstname);
        populateLastNameField(lastname);
        populateEmailAddressField(email);
        populatePasswordField(password);
        populateFirstNameYourAddressField(firstnameaddress);
        populateLastNameYourAddressField(lastnameaddress);
        populateAddressField(address);
        populateCityField(city);
        populateStateField(state);
        populatePostalCodeField(postalcode);
        populateCountryField(country);
        populateMobilePhoneField(phone);
        populateAddressAliasField(aliasaddress);

        clickRegister();
    }




}

