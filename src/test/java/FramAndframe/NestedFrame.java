package FramAndframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void nestedFramePractice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebElement topFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String expectedText = "LEFT";
        Assert.assertEquals(BrowserUtils.getText(left), expectedText);

    //MIDDLE AND RIGHT
        //have to go back to top then go to middle cuz we are at left//cannot swith between siblings
        driver.switchTo().parentFrame();//
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        Assert.assertEquals(BrowserUtils.getText(middle),"MIDDLE");

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertEquals(BrowserUtils.getText(right),"RIGHT");

    //BOTTOM FRAME
        //we are at right, go back to top , go back to main then access bottom
//        driver.switchTo().parentFrame();//go back to top
//        driver.switchTo().parentFrame();//go back to main entrance
        //IF WE HAVE MORE THAN 1,2 PARENTS, THEN USE IT
        driver.switchTo().defaultContent();//directly to the main HTML
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        Assert.assertEquals(BrowserUtils.getText(bottom),"BOTTOM");




    }








}
