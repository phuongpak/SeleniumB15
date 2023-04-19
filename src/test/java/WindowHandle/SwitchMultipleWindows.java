package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindows {

    @Test
    public void multipleWindowsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        BrowserUtils.switchByTitle(driver,"Contact us");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Home");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Courses");
        Thread.sleep(3000);

        driver.quit();

    }


    @Test
    public void multipleWindowPractice2() throws InterruptedException {
                /*

        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful"
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and click  the "Click Me" button under prompt box
        7-quit all the pages.
        8-Proud of yourself

                 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4= driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Basic Controls");


        Thread.sleep(4000);


        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstNameBox.sendKeys("PHUONG");

        WebElement lastNameBox = driver.findElement(By.cssSelector("#lastName"));
        BrowserUtils.scrollWithJS(driver,lastNameBox);
        lastNameBox.sendKeys("PAK");

        WebElement genderButton = driver.findElement(By.cssSelector("#femalerb"));
        genderButton.click();

        WebElement languageKnowButton = driver.findElement(By.cssSelector("#englishchbx"));
        languageKnowButton.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("p.doan8x@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345678");


        WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.scrollWithJS(driver,registerButton);
        //registerButton.click();NOT WORKING
        BrowserUtils.clickWithJS(driver,registerButton);


        WebElement message = driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]"));
        Assert.assertEquals(BrowserUtils.getText(message), "Registration is Successful");

        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header),"Window Handles Practice");

        BrowserUtils.switchByTitle(driver,"AlertsDemo");

        WebElement clickMe = driver.findElement(By.cssSelector("#promptBox"));

       BrowserUtils.scrollWithJS(driver,clickMe);
        clickMe.click();

        driver.quit();





    }

}
