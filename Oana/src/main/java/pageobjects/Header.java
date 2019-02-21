package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Header {
        WebDriver webDriver;
        By signInLocator=By.name("Sign in");
        By signOutLocator=By.name("Sign out");
        By userNameLocator=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");

   public Header(WebDriver webDriver ){
       this.webDriver=webDriver;

    }
    public void clickSignIn(){
    webDriver.findElement(signInLocator).click();
    }
    public void clickSignOut(){
       webDriver.findElement(signOutLocator).click();
    }
    public void checkUserName(String firstName, String lastName){
    Assert.assertEquals(webDriver.findElement(userNameLocator).getText(),firstName+" "+lastName);
    }
}
