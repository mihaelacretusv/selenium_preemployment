package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegiterSecondPage {
    WebDriver webDriver;
    By firstName = By.id("customer_firstname");
    By lastName = By.name("customer_lastname");
    By email = By.name("email");
    By password = By.name("passwd");
    By firstNameL = By.name("firstname");
    By lastNameL = By.name("lastname");
    By adress = By.name("address1");
    By city = By.name("city");
    By state = By.xpath("//*[@id=\"uniform-id_state\"]/span");
    By zip = By.xpath("//*[@id=\"postcode\"]");
    By country = By.xpath("//*[@id=\"uniform-id_country\"]/span");
    By mobilePhone = By.xpath("//*[@id=\"phone_mobile\"]");
    By adressAlias = By.xpath("//*[@id=\"alias\"]");

    public RegiterSecondPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void insertFirstName(String firstNames) {
        WebElement insertFisrtName = webDriver.findElement(firstName);

        insertFisrtName.click();
        insertFisrtName.sendKeys(firstNames);

    }

    public void insertLastName(String lastNames) {
        WebElement insertLastName = webDriver.findElement(lastName);
        insertLastName.click();
        insertLastName.sendKeys(lastNames);

    }

    public void insertEmail(String emails)
    {
        WebElement insetEmail = webDriver.findElement(email);
        insetEmail.click();
        insetEmail.sendKeys(emails);

    }




}
