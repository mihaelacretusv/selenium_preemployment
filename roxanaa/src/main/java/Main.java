import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://automationpractice.com/index.php");
        WebElement element = webdriver.findElement(By.cssSelector("#search_query_top"));
        List<WebElement> products= webdriver.findElements(By.className("product-image-container"));

        //get element attribute
        System.out.println("Get element attribute");
        System.out.println(element.getAttribute("placeholder"));

        //insert text into element
        element.sendKeys("Cauta search");
        System.out.println(element.getAttribute("value"));

        element.clear();

        System.out.println(products.size());

        WebElement productPanel =webdriver.findElement(By.id("homefeatured"));
        List <WebElement> goodList = productPanel.findElements(By.className("product-image-container"));
        System.out.println(goodList.size());

        webdriver.close();
    }
}
