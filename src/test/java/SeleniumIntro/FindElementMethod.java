package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementMethod {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/davidmacbookpro13/Downloads/Techtorialhtml.html");

        //tobe able to use list , this element has to be common,
        List <WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));//4 elements
        for(WebElement box : allBoxes){
            Thread.sleep(3000);
            if(box.isDisplayed()&& !box.isSelected() && box.isEnabled()){
                box.click();
            }
        }









    }


}
