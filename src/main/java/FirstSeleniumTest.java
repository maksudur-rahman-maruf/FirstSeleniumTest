import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;


public class FirstSeleniumTest {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String searchElement = "[name=" + '"' + "q" + '"' + "]";

        driver.manage().window().maximize();
//        driver.manage().window().minimize();
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

        driver.manage().window().setSize(new Dimension(800, 600));
        Thread.sleep(2000);

        int positionX = driver.manage().window().getPosition().getX();
        System.out.println(positionX);
        int positionY = driver.manage().window().getPosition().getY();
        System.out.println(positionY);

        driver.manage().window().setPosition(new Point(200, 500));

        //Take Screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./screenshots/images1.png"));

        WebElement element = driver.findElement(By.cssSelector(".blog-name"));
        File srcFile1 = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile1, new File("./screenshots/images2.png"));

        // Getting JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement button = driver.findElement(By.cssSelector(".wpfront-button[href=" + '"' + "https://automationstepbystep.com/stories/" + '"' + "]"));
        js.executeScript("arguments[0].click();", button);
        js.executeScript("console.log(' Hello World ... ')"); // Console.log somehow doesn't execute Properly here.  But It works Fine on other sites/window.

        // Relative Locator
//        WebElement archivesButton = driver.findElement(By.cssSelector(".entry p:first-child a:last-child"));
//        WebElement storiesButton = driver.findElement(RelativeLocator.with(By.tagName("a")).above(archivesButton));
//        storiesButton.click();

        Thread.sleep(2000);
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
}
