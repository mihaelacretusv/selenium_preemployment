package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login {

    By emailAdressLabelLocator = By.xpath("//*[@id=\"email\"]");
    By passwordLabelLocator = By.xpath("//*[@id=\"passwd\"]");
    By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    By errorAlert=By.xpath("//*[@id=\"center_column\"]/div[1]");
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginPage()

    {
        Header h1 = new Header(this.driver);
        h1.clickSignIn();
    }


    public void clickemailAdress() {
        WebElement clickmail = driver.findElement(emailAdressLabelLocator);
        clickmail.click();


    }

    public void clickpassword() {
        WebElement clickpassword = driver.findElement(passwordLabelLocator);
        clickpassword.click();
    }

    public void populateEmailAdress(String emailAdress) {
        WebElement populateEmail = driver.findElement(emailAdressLabelLocator);
        populateEmail.sendKeys(emailAdress);
    }

    public void populatepassword(String password) {
        WebElement populatePass = driver.findElement(passwordLabelLocator);
        populatePass.sendKeys(password);

    }

    public void clickSignInClick() {

        WebElement clickSignIn = driver.findElement(signInButton);
        clickSignIn.click();
    }



    public void loginValidUser(String username, String password) {

        Header h1 = new Header(this.driver);
        h1.checkSignOutButton();

    }

    public  void signOut()
        {
            Header h1=new Header(this.driver);
            h1.clickSignOut();


        }

    public void InvalidUser ()

    {

        clickemailAdress();
        populateEmailAdress("a.a.com");
        clickpassword();
        populatepassword("as");
        clickSignInClick();
        WebElement error=driver.findElement(errorAlert);
        error.getText();


    }




}
