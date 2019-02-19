import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sort {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","..\\chromedriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
        WebElement element = webDriver.findElement(By.id("productsSortForm"));

        List<WebElement> products = webDriver.findElements(By.cssSelector("[itemprop=\"name\"]"));
        //List<WebElement> products = webDriver.findElements(By.cssSelector("[itemtype=\"http://schema.org/Product\"]"));

        //list number of articles Visible
        System.out.println("Nr.Products: ");
        WebElement productPanel = webDriver.findElement(By.className("product_list"));
        List<WebElement> availableProducts = productPanel.findElements(By.className("product-container"));
        System.out.println(availableProducts.size());


        for (WebElement e: products)
        {
            System.out.println(e.getAttribute("innerText"));
        }


        //Close BROWSER
        webDriver.close();
    }
}
