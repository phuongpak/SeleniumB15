package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {


    WebDriver driver;
    @Test
    public void validateTheText(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dynamicLoadingLink = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]"));
        dynamicLoadingLink.click();
        WebElement example1 = driver.findElement(By.partialLinkText("Example 1"));
        example1.click();
        WebElement startButton = driver.findElement(By.xpath("//button[.='Start']"));
        startButton.click();
        WebElement text = driver.findElement(By.xpath("//div[@id='finish']//h4"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        text =wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }

    @Test
    public void validateText2(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dynamicControlLink = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Controls')]"));
        dynamicControlLink.click();
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        message = wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");

    }






}
