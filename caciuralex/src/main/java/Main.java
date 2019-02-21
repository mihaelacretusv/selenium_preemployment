import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String pathToDriver = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");

        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products = webDriver.findElements(By.className("product-image-container"));


        //get attribute
        System.out.println("Get element attribute");
        System.out.println(element.getAttribute("placeholder"));
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //type text in text entry element
        System.out.println("Type text in text entry element");
        element.sendKeys("goooogle");
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //get text
        System.out.println("Get text");
        System.out.println(element.getText());
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //clear
        System.out.println("Clear text from entry element");
        element.clear();
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        WebElement product = webDriver.findElement(By.id("homefeatured"));

        List<WebElement> productName = product.findElements(By.className("product-container"));
        System.out.println(productName.size());

        List<WebElement> productPrice = product.findElements(By.className("right-block"));
        System.out.println(productPrice.size());

        webDriver.close();
    }
}