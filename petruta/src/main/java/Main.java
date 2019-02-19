import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products = webDriver.findElements(By.className("product-image-container"));

        //get element attribute
        System.out.println("get element atribute");
        System.out.println(element.getAttribute("placeholder"));


        //insert text in element
        element.sendKeys("Blouses");

        //get element text
        System.out.println(element.getAttribute("value"));

        //clear the text inside element
        element.clear();

        //check element is visible
        System.out.println( element.isDisplayed());


        System.out.println(products.size());
        WebElement visible = webDriver.findElement(By.id("homefeatured"));
        List<WebElement>  good = visible.findElements(By.className("product-container"));

        System.out.println(good.size());

        for (int i=1 ; i< good.size(); i++)
        {
            System.out.println(good.get(i).findElement(By.className("content_price")).getAttribute("innerText"));
        }


        webDriver.close();





    }


}
