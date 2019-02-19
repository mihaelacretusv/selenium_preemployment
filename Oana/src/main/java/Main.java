import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.WEmbeddedFrame;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\selenium_preemployment\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement element=webDriver.findElement(By.name("search_query"));
        List<WebElement> products=webDriver.findElements(By.className("product-image-container"));

        //get element attribute
        System.out.println("Atribut: "+element.getAttribute("placeholder"));


        //insert text
        System.out.println("my text: ");
        element.sendKeys("My text is here");

        //get text
        System.out.println("Textul este:  "+element.getAttribute("value"));

        //display
        System.out.println("Element is dysplayed: "+element.isDisplayed());


        //clear
        System.out.println("Stergere element");
        element.clear();

        System.out.println("Number of articles");
        System.out.println(products.size());
        System.out.println("Numar gresit");


        System.out.println("Correct number of articles");
        WebElement product=webDriver.findElement(By.id("homefeatured"));
        List<WebElement>articole=product.findElements(By.className("product-container"));
        System.out.println(articole.size());

    webDriver.close();
    }


}
