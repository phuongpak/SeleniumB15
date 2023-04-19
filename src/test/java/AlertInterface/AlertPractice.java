package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void AlertPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");


        WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMeButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message) ,"You selected alert popup");


        Thread.sleep(3000);
        WebElement clickDismissMeButton = driver.findElement(By.cssSelector("#confirmBox"));
        clickDismissMeButton.click();
        Assert.assertEquals(alert.getText(), "Press a button!");

        alert.dismiss();
        WebElement messageDismiss = driver.findElement(By.xpath("//div[contains(@id,'output')]"));
        Assert.assertEquals(BrowserUtils.getText(messageDismiss), "You pressed Cancel in confirmation popup");

        Thread.sleep(3000);
        WebElement clickMeButtonSendKeys = driver.findElement(By.cssSelector("#promptBox"));
        clickMeButtonSendKeys.click();
        alert.sendKeys("phuong");
        alert.accept();

        WebElement messageAfterSendingKey = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(messageAfterSendingKey),"You entered text phuong in propmt popup");



    }

}
