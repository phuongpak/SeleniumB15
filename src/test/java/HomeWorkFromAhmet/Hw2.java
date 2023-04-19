package HomeWorkFromAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Hw2 {
    /*
    https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html
   Click all the boxes when aria-label is false (Think about getAttribute method)

     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        List<WebElement> checkAllBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for(WebElement box:checkAllBoxes){
            Thread.sleep(1000);

            if(box.isDisplayed()&& !box.isSelected()&& box.isEnabled()&& box.getAttribute("aria-checked").equals("false")){
                box.click();

            }
        }
        driver.close();









    }
}
