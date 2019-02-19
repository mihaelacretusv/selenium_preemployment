import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Flder\\chromedriver.exe" );
        WebDriver webDriver= new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element= webDriver.findElement(By.name("search_query"));
        List<WebElement> products= webDriver.findElements(By.className("product-image-container"));

        //get element attribute
        System.out.println("Get element attribute");
        element.getAttribute("placeholder");
        System.out.println(element.getAttribute("placeholder"));

        //insert text in element
        System.out.println("Insert text in element");
        System.out.println("element.getText()");
        System.out.println(element.getAttribute("value"));

        //get element clear
        System.out.println("Get element clear");
        element.clear();

        System.out.println(element.isDisplayed());

        System.out.println("List number of products :");
        System.out.println(products.size());

        WebElement parent = webDriver.findElement(By.id("homefeatured"));
        List<WebElement> product = parent.findElements(By.className("product-container"));
        System.out.println(product.size());
    }







}
