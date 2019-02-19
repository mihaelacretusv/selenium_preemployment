import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static void main(String[] arg) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C://selenium//chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products = webDriver.findElements(By.className("product-image-container"));

        System.out.println("get element attributes");
        System.out.println(element.getAttribute("placeholder"));

        System.out.println("insert text");
        element.sendKeys("dresses");

        System.out.println("get text");
        System.out.println(element.getAttribute("value"));
        System.out.println(element.isDisplayed());

        System.out.println("clear");
        element.clear();

        System.out.println(products.size());
        WebElement product = webDriver.findElement(By.id("homefeatured"));
        List<WebElement> goodproducts= product.findElements(By.className("product-image-container"));
        System.out.println(goodproducts.size());
        webDriver.close();


    }
}
