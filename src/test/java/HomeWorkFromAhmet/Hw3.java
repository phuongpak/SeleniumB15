package HomeWorkFromAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class Hw3 {

    @Test
    public void switchPageId(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findOutWhichCourseIsForYouButton = driver.findElement(By.xpath("//span[@id='el_1670489249530_347']"));
        BrowserUtils.scrollWithJS(driver,findOutWhichCourseIsForYouButton);
        findOutWhichCourseIsForYouButton.click();
        //switch 2 windows
        String homePageId = driver.getWindowHandle();
        System.out.println(homePageId);
        Set<String> allPageId = driver.getWindowHandles();
        System.out.println(allPageId);
        for(String id : allPageId){
            while(!id.equals(homePageId)){
               driver.switchTo().window(id);
               break;
            }
        }

        BrowserUtils.getTitleWithJS(driver);
        System.out.println( BrowserUtils.getTitleWithJS(driver) );

        driver.close();

    }


}
