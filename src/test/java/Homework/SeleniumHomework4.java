package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumHomework4 {
    //CREATE THE PROJECT OUTSIDE SELENIUM B15 AND DO IT
    /*
     Navigate to "http://uitestpractice.com/Students/Select#"
     Validate India is selected by default on drop down box
        Validate the size of the Drop down box is 4
         Validate the values for Drop down box are :
                India
                United States of America
                China England
        Select the China with index number Select the England with value
        Select the United States with visible text
     */

    @Test
    public void testCase1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/Students/Select#");





    }

}
