package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {
    WebDriver webDriver;
    private By firstNameLocator = By.id("customer_firstname");
    private By lastNameLocator = By.id("customer_lastname");
    private By emailAddressLocator = By.id("email");
    private By passwordLocator= By.id("passwd");
    private By firstNameAddressLocator= By.id("firstname");
    private By lastNameAddressLocator= By.id("lastname");
    private By addressLocator=By.id("address1");
    private By cityLocator = By.id("city");
    private Select stateLocator = new Select(webDriver.findElement(By.id("id_state")));
    private By zipLocator = By.id("id_state");
    private Select countryLocator = new Select(webDriver.findElement(By.id("id_country")));
    private By mobilePhoneLocator = By.id("phone_mobile");
    private By assignAddressLocator = By.id("alias");
    private By registerLocator = By.xpath("//*[@id=\"submitAccount\"]/span/text()");


    public void populateFirstName(String firstName){
        webDriver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void populateLastName(String lastName){
        webDriver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void populateEmailAddress(String emailAddress){
        webDriver.findElement(emailAddressLocator).sendKeys(emailAddress);
    }

    public void populatePasswordLocator(String password){
        webDriver.findElement(passwordLocator).sendKeys(password);
    }

    public void populateFirstNameAddressLocator(String firstNameAddress){
        webDriver.findElement(firstNameAddressLocator).sendKeys(firstNameAddress);
    }
    public void populateLastNameAddressLocator(String lastNameAddress){
        webDriver.findElement(lastNameAddressLocator).sendKeys(lastNameAddress);
    }

    public void populateAddressLocator(String address){
        webDriver.findElement(addressLocator).sendKeys(address);
    }

    public void populateCityLocator(String city){
        webDriver.findElement(cityLocator).sendKeys(city);
    }

     public void selectState(String state ){
        stateLocator.selectByValue(state);
     }
    public void populateZipLocator(String zip){
        webDriver.findElement(zipLocator).sendKeys(zip);
    }

    public void selectCountry(String country){
        countryLocator.selectByValue(country);
    }

    public void populateMobilePhoneLocator(String phone){
        webDriver.findElement(mobilePhoneLocator).sendKeys(phone);
    }

    public void populateAssignAddressLocator(String assignAddress){
        webDriver.findElement(assignAddressLocator).sendKeys(assignAddress);
    }

    public void clickRegister(){
        webDriver.findElement(registerLocator).click();
    }

}
