package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class SeleniumHomework1 {

    @Test
    public void Case1() throws InterruptedException {
      /*
      ////TEST CASE 1://///
      Navigate to "https://demoqa.com/text-box"
    Enter your full name, email, current and permanent address Click submit button.
    Validate that all of your information is displayed and matching correctly.
    TIPS:Think about if conditions.
    Example:
    Name:David
    Email: david@gmail.com
    Current Address :Random Address
    Permanent Address : different address
       */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("PHUONG PAK");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("p.doan8x@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("5th Ave, Naperville, IL, 60563");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys(" 860 W, 75th St, Naperville, IL, 60565");


        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(4000);
        submitButton.click();


        List<WebElement> allInformation = driver.findElements(By.cssSelector(".mb-1"));


       List<String> expectedInformation = Arrays.asList
                ("Name:PHUONG PAK","Email:p.doan8x@gmail.com","Current Address :5th Ave, Naperville, IL, 60563","Permananet Address :860 W, 75th St, Naperville, IL, 60565");


        for (int i =0; i<allInformation.size();i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }


        driver.close();
    }


    @Test
    public void Case2() {

    /*
    TEST CASE 2:
        Steps
    Navigate to "https://demoqa.com/radio-button" Click Yes radio button
    Validate text is : You have selected Yes
    Click Impressive radio button
    Validate text is : You have selected Impressive
    TIPS: be careful about your xpath if you have any issue with getting the text.
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();

        WebElement yesSelectedButton= driver.findElement(By.cssSelector(".mt-3"));
        //System.out.println(yesSelected.getText().trim());
        String actualYesSelected = yesSelectedButton.getText().trim();
        String expectedYesSelected ="You have selected Yes";
        System.out.println(actualYesSelected.equals(expectedYesSelected)? "validating text yes passed" : " validating text Yes failed");


        WebElement impressiveSelectedButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveSelectedButton.click();

        WebElement impressiveSelectedDisplayed= driver.findElement(By.cssSelector(".mt-3"));
        Assert.assertTrue(impressiveSelectedDisplayed.isDisplayed());

        driver.close();

    }

    @Test
    public void case3(){
    /*
        Navigate to "https://www.saucedemo.com/" Enter username "Java"
    Enter password "Selenium"
    Click Login button
    Validate "Epic sadface: Username and password do not match any user in this service" message
    TIPS:to be able to see this message you need to first see this message then try to inspect it.
     (it means at least run one time with the username and password you provided above to see
     the message then inspect the message.*be careful with it is fully copied or not.
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement sadFaceMessage = driver.findElement(By.xpath("//h3"));
        String actualSadFaceMessage = sadFaceMessage.getText().trim();
        String expectedSadFaceMessage ="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualSadFaceMessage,expectedSadFaceMessage);

    }

    @Test
    public void case4(){
        /*
        Navigate to "https://www.saucedemo.com/" Enter username "standard_user"
        Enter password "secret_sauce"
        Click Login button
        Validate current url is "https://www.saucedemo.com/inventory.html"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl,expectedUrl);

    }











}













