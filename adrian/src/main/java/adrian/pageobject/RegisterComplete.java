package adrian.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class RegisterComplete {
    public WebDriver driver;

    // INPUT
    By registerPIFirstName = By.xpath("//*[@id=\"customer_firstname\"]");
    By registerPILastName = By.id("customer_lastname");
    //By registerEmail = By.id("email"); - AUTOCOMPLETE
    By registerPassword = By.id("passwd");
    //By registerFiName = By.id("firstname");
    //By registerLaName = By.id("lastname");
    By registerAdress = By.id("address1");
    By registerCity = By.id("city");
    By registerPostalcode = By.id("postcode");
    By registerPhone = By.id("phone_mobile");
    By registerAliasAdress = By.id("alias");

    // DROPDOWN
    By registerState = By.id("id_state");
    //By registerCountry = By.id("country");
    By registerDaysDate = By.xpath("//*[@id=\"days\"]");
    By registerMonthsDate = By.xpath("//*[@id=\"months\"]");
    By registerYearsDate = By.xpath("//*[@id=\"years\"]");

    // Button
    By clickRegister = By.id("submitAccount");


    public RegisterComplete(WebDriver driver) {
        this.driver = driver;
    }


    public void populatePIFirstName(String regfirstname) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPIFirstName));
        driver.findElement(registerPIFirstName).click();
        driver.findElement(registerPIFirstName).clear();
        driver.findElement(registerPIFirstName).sendKeys(regfirstname);
    }

    public void populatePILastName(String reglastname) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPILastName));
        driver.findElement(registerPILastName).click();
        driver.findElement(registerPILastName).clear();
        driver.findElement(registerPILastName).sendKeys(reglastname);
    }


    public void populatePass(String regpass) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPassword));
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).clear();
        driver.findElement(registerPassword).sendKeys(regpass);
    }

    public void populateAdress(String adress) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerAdress));
        driver.findElement(registerAdress).click();
        driver.findElement(registerAdress).clear();
        driver.findElement(registerAdress).sendKeys(adress);
    }

    public void populateCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerCity));
        driver.findElement(registerCity).click();
        driver.findElement(registerCity).clear();
        driver.findElement(registerCity).sendKeys(city);
    }

    public void populatePostalcode(String postalcode) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPostalcode));
        driver.findElement(registerPostalcode).click();
        driver.findElement(registerPostalcode).clear();
        driver.findElement(registerPostalcode).sendKeys(postalcode);
    }

    public void populatePhone(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPhone));
        driver.findElement(registerPhone).click();
        driver.findElement(registerPhone).clear();
        driver.findElement(registerPhone).sendKeys(phone);
    }

    public void populateAliasAdress(String aliasadres) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerAliasAdress));
        driver.findElement(registerAliasAdress).click();
        driver.findElement(registerAliasAdress).clear();
        driver.findElement(registerAliasAdress).sendKeys(aliasadres);
    }

    public void dropdownStatePopulate(String value) {
        Select element = new Select(driver.findElement(registerState));
        element.selectByValue(value);
    }

    public void dropdownDaysPopulate(String value) {
        Select element = new Select(driver.findElement(registerDaysDate));
        element.selectByValue(value);
    }

    public void dropdownMonthsPopulate(String value) {
        Select element = new Select(driver.findElement(registerMonthsDate));
        element.selectByValue(value);
    }

    public void dropdownYearsPopulate(String value) {
        Select element = new Select(driver.findElement(registerYearsDate));
        element.selectByValue(value);
    }

    public void createNewAccountWithRegisterButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickRegister));
        driver.findElement(clickRegister).click();
    }


    public void registerUserWithAllMandatoryCompletedCorrectly(String firstname, String lastname, String password, String day, String month, String year, String adress, String city, String state, String postalcode, String phone, String adressalias) {
        populatePIFirstName(firstname);
        populatePILastName(lastname);
        populatePass(password);
        dropdownDaysPopulate(day);
        dropdownMonthsPopulate(month);
        dropdownYearsPopulate(year);
        populateAdress(adress);
        populateCity(city);
        dropdownStatePopulate(state);
        populatePostalcode(postalcode);
        populatePhone(phone);
        populateAliasAdress(adressalias);
    }


}
