package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {

    WebDriver driver;
    By email = By.id("email");
    By password = By.id("passwd");
    By sign = By.id("SubmitLogin");
    By error=By.xpath("//*[@id=\"center_column\"]/div[1]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void populateEmail(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(address);

    }

    public void populatePassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignIn() {
        driver.findElement(sign).click();
    }

    public void loginValidUser(String address, String pass) {
        populateEmail(address);
        populatePassword(pass);
        clickSignIn();
    }

    public void loginInvalidUser(String address,String pass){
        populateEmail(address);
        populatePassword(pass);
        clickSignIn();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        checkLoginError();
    }

    public void checkLoginError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]")).isDisplayed();

    }
}
