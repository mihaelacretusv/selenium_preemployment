import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\01_Softvision\\Pre employment\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products= webDriver.findElements(By.className("product-image-container"));


        //get element attribute
        System.out.println("get element attribute");
        System.out.println(element.getAttribute("placeholder"));
        webDriver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

        //insert text in element
        System.out.println("insert text in element");
        element.sendKeys("here is my text");
        webDriver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

        //get element text
        System.out.println("get element text");
        System.out.println(element.getText());
        webDriver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

        //clear the text inside element
        System.out.println( "clear the text inside element");
        element.clear();
        webDriver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

        //check element is visible
        System.out.println("check element is visible");
        System.out.println(element.isDisplayed());
        webDriver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

        //list number of articles
        System.out.println("list number of articles");
        System.out.println(products.size());
        webDriver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        System.out.println("that's not correct!");

        System.out.println("list THE CORRECT number of articles");
        WebElement productPanel = webDriver.findElement(By.id("homefeatured"));
        List<WebElement> goodProducts = productPanel.findElements(By.className("product-image-container"));
        System.out.println(goodProducts.size());

        //close driver
        webDriver.close();
    }
}
