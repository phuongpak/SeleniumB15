package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethods {

@Test//contextclick means right click
    public void ContextClick(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.navigate().to("https://the-internet.herokuapp.com/");

    WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
    contextMenu.click();

    WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
    Actions actions = new Actions(driver);
    actions.contextClick(box).perform();


}

    @Test
    public void contextPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick = driver.findElement( By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();
    }

    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();


    }







}
