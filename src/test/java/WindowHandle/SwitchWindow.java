package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        String mainPageID =driver.getWindowHandle();//pageID of the class
        System.out.println(mainPageID);

        Set<String> allPageID = driver.getWindowHandles();// with s so set<>
        System.out.println(allPageID);
        for(String id:allPageID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }


        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(header));


    }

    @Test
    public void practice1(){
        /*
        TASK:
        1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
        2-Click Open New Tab under Button2
        3-Get the title of the newTab and validate"
        4-Get the header of the newTab and validate "AlertsDemo"
        5-Click click me button
        6-Quit the tabs
    */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement Button2 = driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollWithJS(driver,Button2);
        Button2.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> allPageIDS = driver.getWindowHandles();
        for(String id: allPageIDS){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }



        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");
        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header),"AlertsDemo");

        WebElement clickButton = driver.findElement(By.cssSelector("#alertBox"));
        clickButton.click();
        driver.quit();


    }







}
