package JavaScriptExecutor;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptMethods {


    @Test
    public void getTitle(){
        //we use JavaScript methods  when Selenium methods are not working
        //as expected.Specifically, click, getTitle,
        //NOTE:We love using ScrollIntoView Method from JavaScript in
        //professional environment

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle() + "this is regular driver method for title");

        //if this one is not working then I need to use JS method
        JavascriptExecutor js =(JavascriptExecutor) driver;//casting//your driver is acting like JS executor
        String title = js.executeScript("return document.title").toString();
        System.out.println(title +"this is JS method for title");

    }

    @Test
    public void clickJs(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.cssSelector("#yesRadio"));
       // yesButton.click();//not working in this case, so use JS EXECUTOR

        JavascriptExecutor js =(JavascriptExecutor)driver;//ONLY CREATE ONE TIME

        js.executeScript("arguments[0].click()",yesButton);

        WebElement message = driver.findElement(By.cssSelector(".mt-3"));//use for bothe yes button and impressive butoon

        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage ="You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()", impressiveButton);
        //the same message so no need to create message webelement
        String actualImpressiveButton = BrowserUtils.getText(message);
        String expectedImpressiveButton ="You have selected Impressive";
        Assert.assertEquals(actualImpressiveButton,expectedImpressiveButton);

        driver.close();

    }

    @Test
    public void srollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]//.."));
        //scroll down, click and validate title
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findCourse);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()",findCourse);
        js.executeScript("return document.title");


    }
    @Test
    public void shotCutJSMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]//.."));
        //scroll down, click and validate title
        Thread.sleep(3000);
        BrowserUtils.scrollWithJS(driver,findCourse);
        BrowserUtils.clickWithJS(driver,findCourse);
        Thread.sleep(3000);
        System.out.println(BrowserUtils.getTitleWithJS(driver));
        driver.close();


    }

    @Test
    public void validateApply() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement copyRight = driver.findElement(By.xpath("//div[@id='el_1666192783854_462']"));
       //find the element then scroll down
        BrowserUtils.scrollWithJS(driver,copyRight);
        String actualCopyRight = BrowserUtils.getText(copyRight);
        String expectedCopyRight ="Copyright © 2023";
        Assert.assertEquals(actualCopyRight,expectedCopyRight);

        WebElement applyButton = driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        BrowserUtils.scrollWithJS(driver,applyButton);
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver,applyButton);

        List<WebElement> allAppliedInfo = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");


        for(int i=0;i<allAppliedInfo.size();i++){
            Assert.assertEquals( BrowserUtils.getText(allAppliedInfo.get(i)), expectedInfo.get(i) );
        }

        driver.close();




    }









}
