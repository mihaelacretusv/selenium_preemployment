package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MandatoryFields {
    WebDriver driver;
    By first = By.id("customer_firstname");
    By last = By.id("customer_lastname");
    By pwd = By.id("passwd");
    By name = By.id("firstname");
    By surname = By.id("lastname");
    By addres = By.id("address1");
    By cit = By.id("city");
    By zip = By.id("postcode");
    By phone = By.id("phone_mobile");
    By state = By.id("id_state");
    By country = By.id("id_country");
    By addres2 = By.id("alias");
    By register = By.id("submitAccount");


    public MandatoryFields(WebDriver driver) {
        this.driver = driver;
    }

    public void populateFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(first));
        driver.findElement(first).click();
        driver.findElement(first).clear();
        driver.findElement(first).sendKeys(firstName);
    }

    public void populateLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(last));
        driver.findElement(last).click();
        driver.findElement(last).clear();
        driver.findElement(last).sendKeys(lastName);
    }

    public void populatePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pwd));
        driver.findElement(pwd).click();
        driver.findElement(pwd).clear();
        driver.findElement(pwd).sendKeys(password);
    }

    public void populateFirst(String first) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        driver.findElement(name).click();
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(first);
    }

    public void populateLast(String last) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(surname));
        driver.findElement(surname).click();
        driver.findElement(surname).clear();
        driver.findElement(surname).sendKeys(last);
    }

    public void populateAddress(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addres));
        driver.findElement(addres).click();
        driver.findElement(addres).clear();
        driver.findElement(addres).sendKeys(address);
    }

    public void populateCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cit));
        driver.findElement(cit).click();
        driver.findElement(cit).clear();
        driver.findElement(cit).sendKeys(city);
    }

    public void populateZip(String postal) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zip));
        driver.findElement(zip).click();
        driver.findElement(zip).clear();
        driver.findElement(zip).sendKeys(postal);
    }

    public void populatePhone(String number) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
        driver.findElement(phone).click();
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(number);
    }

    public void populateState(String stat) {

        Select select = new Select(driver.findElement(state));
        select.selectByValue(stat);
    }

    public void populateCountry(String countr) {

        Select select = new Select(driver.findElement(country));
        select.selectByValue(countr);
    }

    public void populateAddress2(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addres2));
        driver.findElement(addres2).click();
        driver.findElement(addres2).clear();
        driver.findElement(addres2).sendKeys(address);
    }

    public void clickRegister() {
        driver.findElement(register).click();
    }

    public void populateAll(String firstname, String lastname, String password, String address, String city, String postal, String phone) {
        populateFirstName(firstname);
        populateLastName(lastname);
        populateFirst(firstname);
        populateLast(lastname);
        populateAddress(address);
        populateAddress2(address);
        populateCity(city);
        populatePhone(phone);
        populateZip(postal);
        populatePassword(password);
        populateCountry("21");
        populateState("1");
        clickRegister();
    }
}
