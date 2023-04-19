package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

////button[contains(@onclick,'jsAlert()')]" -> new way to find element contains with attribute
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
                                                                        //button[contains(text(),'Click for JS Alert')]
        alertButton.click();
//create Alert interface
        Alert alert = driver.switchTo().alert();//hey there is a pop up. switch to alert
        String actualJSAlertText = alert.getText();//get the text from Alert POP UP
        String expectedJSAlertText ="I am a JS Alerts";//just added s for example softassert
//       Assert.assertEquals(actualJSAlertText,expectedJSAlertText);//hard assert
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualJSAlertText,expectedJSAlertText,"There is a comparison problem");
        alert.accept();

        WebElement message = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message), "You successfully clicked an alert");

    }

    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        //XXXXXXXX
       // Alert alert = driver.switchTo().alert();//switch alert before pop up show up//IT SHOW EXCEPTION:NOAlertPresentException
        //alert.dismiss();
//        WebElement message = driver.findElement(By.cssSelector("#result"));
//        Assert.assertEquals(BrowserUtils.getText(message), "You clicked: Cancel");


        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message), "You clicked: Cancel");
        Thread.sleep(3000);

    }
    @Test
    public void sendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(3000);

        WebElement alertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("I love UI automation");
        alert.accept();

        WebElement message = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message), "You entered: I love UI automation");
        Thread.sleep(3000);

    }












}
