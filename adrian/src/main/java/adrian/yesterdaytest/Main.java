package adrian.yesterdaytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","..\\chromedriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products = webDriver.findElements(By.className("product-image-container"));

        //get element attribute
        System.out.println("Get element attribute:");
        System.out.println(element.getAttribute("placeholder") + "\n");

        //insert text
        System.out.println("Insert text:");
        element.sendKeys("Lorem Ipsum");

        //get text
        System.out.println("get text");
        System.out.println(element.getText() + element.getAttribute("value"));

        //clear
        System.out.println("clear");
        element.clear();
        //webDriver.close();

        //list number of articles Total
        System.out.println("list number of articles");
        System.out.println(products.size());

        //list number of articles Visible
        System.out.println("Products avaiable in page:");
        WebElement productPanel = webDriver.findElement(By.id("homefeatured"));
        List<WebElement> availableProducts = productPanel.findElements(By.className("product-container"));
        System.out.println(availableProducts.size());

        //HiddenProducts
        System.out.println("Products hidden in page:");
        WebElement productPanel2 = webDriver.findElement(By.id("blockbestsellers"));
        List<WebElement> hiddenProducts = productPanel2.findElements(By.className("product-container"));
        System.out.println(hiddenProducts.size());


        //Close BROWSER
        webDriver.close();
    }
}
