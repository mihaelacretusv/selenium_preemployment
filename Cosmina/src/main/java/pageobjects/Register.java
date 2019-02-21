package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {

    WebDriver webDriver;

    private By firstNamePersonalLocator = By.id("customer_firstname");
    private By lastNamePersonalLocator = By.id("customer_lastname");
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By firstNameAddressLocator = By.id("firstname");
    private By lastNameAddressLocator = By.id("lastname");
    private By addressLocator = By.id("address1");
    private By cityLocator = By.id("city");
    private By stateLocator = By.id("id_state");
    private By postalCodeLocator = By.id("postcode");
    private By countryLocator = By.id("id_country");
    private By mobilePhoneLocator = By.id("phone_mobile");
    private By addressAliasLocator = By.id("alias");
    private By registerLocator = By.id("submitAccount");

    public Register(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void fillFirstNamePersonal(String cosmina) {
        webDriver.findElement(firstNamePersonalLocator).sendKeys(cosmina);
    }

    public void fillLastNamePersonal(String chirila) {
        webDriver.findElement(lastNamePersonalLocator).sendKeys(chirila);
    }

    public void fillEmail(String email) {

        webDriver.findElement(emailLocator).sendKeys(email);
    }

    public void fillPassword(String password) {

        webDriver.findElement(passwordLocator).sendKeys(password);
    }

    public void fillFirstNameAddress(String cosmina) {
        webDriver.findElement(firstNameAddressLocator).sendKeys(cosmina);
    }

    public void fillLastNameAddress(String chirila) {

        webDriver.findElement(lastNameAddressLocator).sendKeys(chirila);
    }

    public void fillAddress(String vladimirescu) {

        webDriver.findElement(addressLocator).sendKeys(vladimirescu);
    }

    public void fillCity(String iasi) {

        webDriver.findElement(cityLocator).sendKeys(iasi);
    }

    public void fillState(String georgia) {
        Select dropdown = new Select(webDriver.findElement(stateLocator));
        dropdown.selectByVisibleText(georgia);
    }

    public void fillPostalCode(String postal) {

        webDriver.findElement(postalCodeLocator).sendKeys(postal);
    }

    public void fillCountry(String romania) {
        Select dropd = new Select(webDriver.findElement(countryLocator));
        dropd.selectByVisibleText(romania);
    }

    public void fillMobilePhone(String phone) {

        webDriver.findElement(mobilePhoneLocator).sendKeys(phone);
    }

    public void fillAddressAlias(String myAddress) {

        webDriver.findElement(addressAliasLocator).sendKeys(myAddress);
    }

    public void clickRegister() {

        webDriver.findElement(registerLocator).click();
    }

    public void registerUser(User user) {
        fillFirstNamePersonal(user.getFirstNamePersonal());
        fillLastNamePersonal(user.getFirstNamePersonal());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        fillFirstNameAddress(user.getFirstNameAddress());
        fillLastNameAddress(user.getLastNameAddress());
        fillAddress(user.getAddress());
        fillCity(user.getCity());
        fillState(user.getState());
        fillPostalCode(user.getPostalCode());
        fillCountry(user.getCountry());
        fillMobilePhone(user.getMobilePhone());
        fillAddressAlias(user.getAddressAlias());
        clickRegister();
    }


}
