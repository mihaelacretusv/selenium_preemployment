import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /*System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products = webDriver.findElements(By.className("product-image-container"));

        //get element attribute
        System.out.println("get element attribute");
        System.out.println(element.getAttribute("placeholder"));

        //insert text element
        System.out.println("insert something");
        element.sendKeys("bla bla");

        //get text
        System.out.println("get text");
        System.out.println(element.getAttribute("value"));

        //clear text
        System.out.println("clear text");
        element.clear();

        System.out.println("list number of articles");
        System.out.println(products.size());

        WebElement parent = webDriver.findElement(By.id("homefeatured"));
        List<WebElement> product = parent.findElements(By.className("product-container"));
        System.out.println(product.size());

    webDriver.close();*/

        String value = "firstName + lastName";
        System.out.println(value);
    }



}
