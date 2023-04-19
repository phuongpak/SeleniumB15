package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    //TASK1:
    //1-LOGIN SUCCESSFULLY WITH"demo" username and "demo"password and validate title
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));//by tagname(button)
        loginButton.click();

        Thread.sleep(3000);//add this cuz before page open it will get title fast so fail

        String actualTitle = driver.getTitle().trim();
        String expectedTitle ="Dashboard";//go to website inspect title, get title, have to login first to get title
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo00");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo0000");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));//by tagname(button)
        loginButton.click();
        Thread.sleep(3000);

         WebElement message = driver.findElement(By.xpath("//div[@id='alert']"));


         String actualMessage= message.getText().trim();
         String expectedMessage ="No match for Username and/or Password.";
        Assert.assertEquals(actualMessage,expectedMessage);//validating

    }

        @Test
    public void mainPage() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver =new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");

            WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
            userName.sendKeys("demo");

            WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
            password.sendKeys("demo");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));//by tagname(button)
            loginButton.click();

            Thread.sleep(3000);//add this cuz before page open it will get title fast so fail


            WebElement xdButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
            xdButton.click();

            WebElement catalogButton = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
            catalogButton.click();
            //after click catalog, wait few second to pop up product
            Thread.sleep(3000);

            WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
            Assert.assertTrue(productButton.isDisplayed());//
            productButton.click();


        }
        //box is displayed, enable, click the box, selected, arrowdown
@Test
    public void validateBoxesFunctionality() throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver =new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://demo.opencart.com/admin/");

    WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
    userName.sendKeys("demo");

    WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
    password.sendKeys("demo");

    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));//by tagname(button)
    loginButton.click();

    Thread.sleep(3000);//add this cuz before page open it will get title fast so fail


    WebElement xdButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
    xdButton.click();

    WebElement catalogButton = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
    catalogButton.click();
    //after click catalog, wait few second to pop up product
    Thread.sleep(3000);

    WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
    productButton.click();


    List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(int i=1; i< boxes.size();i++){
        Thread.sleep(3000);
        Assert.assertTrue(boxes.get(i).isDisplayed());
        Assert.assertTrue(boxes.get(i).isEnabled());
        Assert.assertFalse(boxes.get(i).isSelected());//expect boxes not selected so it is return false
        boxes.get(i).click();
        Assert.assertTrue(boxes.get(i).isSelected());//true
        boxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }

    }

    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));//by tagname(button)
        loginButton.click();

        Thread.sleep(3000);//add this cuz before page open it will get title fast so fail


        WebElement xdButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xdButton.click();

        WebElement catalogButton = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogButton.click();
        //after click catalog, wait few second to pop up product
        Thread.sleep(3000);

        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();

        //new task

        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();

        Thread.sleep(3000);
        List<WebElement> allProductNames = driver.findElements(By.xpath("//td[@class='text-start']"));//11,store all products name in list
        ///String actual list,
        List<String> actualNames = new ArrayList<>();
        List<String>expectedNames = new ArrayList<>();

        for(int i=1; i<allProductNames.size();i++){//we have 10 elements here
            actualNames.add(allProductNames.get(i).getText().toLowerCase().trim());
            expectedNames.add(allProductNames.get(i).getText().toLowerCase().trim());

        }
        //we manipulating expectedNames, then compare it with actual
        Collections.sort(expectedNames);//sorting for ascending
        Collections.reverse(expectedNames);//making guarantee it is descending order
        System.out.println(expectedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames,expectedNames);

    }

    @Test
    public void validate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));//by tagname(button)
        loginButton.click();

        Thread.sleep(3000);//add this cuz before page open it will get title fast so fail


        WebElement xdButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xdButton.click();

        WebElement catalogButton = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalogButton.click();
        //after click catalog, wait few second to pop up product
        Thread.sleep(3000);

        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();

        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();






    }

}












