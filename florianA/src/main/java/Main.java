import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://automationpractice.com/index.php");
        WebElement element = webDriver.findElement(By.name("search_query"));
        List<WebElement> products = webDriver.findElements(By.className("product-image-container"));

        System.out.println("get element attribute:");
        System.out.println(element.getAttribute("placeholder"));
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        element.sendKeys("Cauta aici!");
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        String text = element.getAttribute("value");

        System.out.println(text);
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        element.clear();

        System.out.println(products.size());
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        WebElement parentElement = webDriver.findElement(By.xpath("//*[@id=\"homefeatured\"]"));
        List<WebElement> goodProducts = parentElement.findElements(By.className("left-block"));

        System.out.println(goodProducts.size());

        /*
            pt sort  test
        */

        WebElement searchElement = webDriver.findElement(By.name("search_query"));
        searchElement.sendKeys("dress");
        webDriver.findElements(By.name("submit_search")).get(0).click();

        Select productSort = new Select(webDriver.findElement(By.id("selectProductSort")));
        productSort.selectByIndex(2);
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        productSort.selectByVisibleText("Price: Highest first");

        /**
         * Close browser
         */
        webDriver.close();

    }
}
