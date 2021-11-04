import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstSeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String searchElement = "[name=" + '"' + "q" + '"' + "]";

        driver.manage().window().maximize();

        driver.get("https://google.com/");

        WebElement m = driver.findElement(By.cssSelector(searchElement));

        m.sendKeys("Spring Boot");
        m.sendKeys(Keys.ENTER);

        Thread.sleep(10000);
        driver.close();
    }
}
