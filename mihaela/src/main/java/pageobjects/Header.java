package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Header {

    private WebDriver driver;

    private By signOutBtn = By.className("logout");
    private By signIn = By.className("login");
    private By signOut = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
    private By userAcc = By.className("account");
    private By info = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/span");

    //private Utils util = new Utils();

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void signOut() {
       // util.sleepUntilVisible(signOutBtn, 10, driver);
        driver.findElement(signOutBtn).click();
    }

    public void signIn() {
        // util.sleepUntilVisible(signOutBtn, 10, driver);
        driver.findElement(signIn).click();
    }

    public void checkUserLogged(String username) {
        WebElement elem = driver.findElement(userAcc);

        assertTrue(elem.isDisplayed());
        assertEquals(username, elem.getText());
    }

    public void checkInfo() {
        assertEquals("Call us now: 0123-456-789", driver.findElement(info).getText());
        assertTrue(driver.findElement(info).findElement(By.tagName("i")).isDisplayed());
        assertTrue(driver.findElement(info).findElement(By.xpath("./i")).isDisplayed());
    }
}
