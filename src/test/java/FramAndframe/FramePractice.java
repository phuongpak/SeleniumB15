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

public class FramePractice {

    @Test
    public void iframePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");


        WebElement header = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(BrowserUtils.getText(header) , "An iFrame containing the TinyMCE WYSIWYG Editor") ;

        driver.switchTo().frame("mce_0_ifr");

        WebElement message = driver.findElement(By.cssSelector("#tinymce"));
        message.clear();
        message.sendKeys("I love Selenium");


        driver.switchTo().parentFrame();

        WebElement elementalSeleniumClick = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeleniumClick.click();


        BrowserUtils.switchByTitle(driver,"Using Selenium like a Pro");

        WebElement seleniumHeader2 = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(seleniumHeader2) , "Elemental Selenium");

        driver.quit();





    }



}
