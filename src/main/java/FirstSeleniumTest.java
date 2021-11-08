import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstSeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String searchElement = "[name=" + '"' + "q" + '"' + "]";

        driver.manage().window().maximize();
//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();

        driver.get("https://google.com/");

        String originalWindow = driver.getWindowHandle();

        WebElement m = driver.findElement(By.cssSelector(searchElement));

        m.sendKeys("Spring Boot");
        m.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.navigate().to("https://automationstepbystep.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.switchTo().window(originalWindow);

        int height = driver.manage().window().getSize().getHeight();
        System.out.println(height);
        int width = driver.manage().window().getSize().getWidth();
        System.out.println(width);

        driver.manage().window().setSize(new Dimension(800,600));
        Thread.sleep(2000);

        int positionX = driver.manage().window().getPosition().getX();
        System.out.println(positionX);
        int positionY = driver.manage().window().getPosition().getY();
        System.out.println(positionY);

        driver.manage().window().setPosition(new Point(200, 500));


        Thread.sleep(2000);
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
}
