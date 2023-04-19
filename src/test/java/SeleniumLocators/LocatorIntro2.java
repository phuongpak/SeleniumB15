package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorIntro2 {
    public static void main(String[] args) throws InterruptedException {


       System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("file:///Users/davidmacbookpro13/Downloads/Techtorialhtml.html");

        WebElement javalink = driver.findElement(By.linkText("Java"));
        javalink.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java") ? "passed" : "failed");
        Thread.sleep(2000);
        driver.navigate().back();

        /*

         */

        WebElement Selenium =driver.findElement(By.linkText("Selenium"));
        Selenium.click();
        WebElement header1 = driver.findElement(By.tagName("h1"));//have to find the unique element. h1 is unique
        System.out.println((header1.getText().trim().equals("Selenium automates browsers. That's it!") ?"Passed Selenium" : "Failed Selenium"));
        Thread.sleep(3000);
        driver.navigate().back();

        WebElement Cucumber =driver.findElement(By.linkText("Cucumber"));
        Cucumber.click();
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println((header2.getText().trim().equals("Tools & techniques that elevate teams to greatness") ?"Passed Cucumber" : "Failed Cucumber"));
        Thread.sleep(3000);
        driver.navigate().back();


        WebElement TestNG =driver.findElement(By.linkText("TestNG"));
        TestNG.click();
        WebElement header3 = driver.findElement(By.tagName("h2"));
        System.out.println((header3.getText().trim().equals("TestNG") ?"Passed TestNG" : "Failed TestNG"));
        Thread.sleep(3000);
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl().trim();
        String expectedUrl ="file:///Users/davidmacbookpro13/Downloads/Techtorialhtml.html";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Url passed");
        }else{
            System.out.println("Url failed");
        }


        //PARTIAL LINK TEXT LOCATOR://must have a tag and text

        WebElement restApi =driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        String actualUrlRestApi = driver.getCurrentUrl();
        String expectedUrlRestApi ="https://rest-assured.io/";
        System.out.println(actualUrlRestApi.equals(expectedUrlRestApi) ? "RestApi passed" : "RestApi failed");
        driver.navigate().back();






    }
}
