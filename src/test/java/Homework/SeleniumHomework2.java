package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeleniumHomework2 {
    /*
            Navigate to "http://secure.smartbearsoftware.com/samples/Te stComplete11/WebOrders/Login.aspx?"
        Validate the title is equals to "Web Orders Login"
        Input username "Tester"
        Input password "test"
        Click login button
        Validate the title is equals to "Web Orders"
        Validate header is equals to "List of All Orders"
             */

    @Test
    public void TestCase1() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String expectedTitle ="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement usernameBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 ="Web Orders";
        Assert.assertEquals(actualTitle2,expectedTitle2);

        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader ="List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }

    /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
    Input username "Tester"
    Input password "Test"
    Click login button
    Click "View all products" button
    Validate "View all products" is selected
    Validate header is equals to "List of Products"
    Validate the url has "Products" keyword
     */

    @Test
    public void testCase2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement viewAllProductButton = driver.findElement(By.linkText("View all products"));
        viewAllProductButton.click();
        Thread.sleep(3000);
        WebElement selectedProducts = driver.findElement(By.cssSelector(".selected"));
        Assert.assertTrue(selectedProducts.isDisplayed());

    }
    /*
        Navigate to "http://secure.smartbearsoftware.com/sample s/TestComplete11/WebOrders/Login.aspx?"
        Input username "Tester
        Input password "Test"
        Click login button
        Find the links for
            View all orders
            View all products
            Orders
        Validate their href values are equals to :
        "Default.aspx"
        "Products.aspx"
        "Process.aspx"
         */
    @Test
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement viewAllOrdersLink = driver.findElement(By.linkText("View all orders"));
        viewAllOrdersLink.click();
        System.out.println( driver.getCurrentUrl() );
        Thread.sleep(3000);

        WebElement viewAllProductsLink = driver.findElement(By.linkText("View all products"));
        viewAllProductsLink.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        WebElement ordersLink = driver.findElement(By.linkText("Order"));
        ordersLink.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        //validate href
        List<WebElement> allLinkValues = driver.findElements(By.xpath("//li//a"));
        List<String> expectedLinks = Arrays.asList("Default.aspx","Products.aspx","Process.aspx");
       // List<String> actualLinks = new ArrayList<>();
        for(int i =1; i< allLinkValues.size();i++){
            Assert.assertEquals(allLinkValues.get(i).getAttribute("href"),expectedLinks.get(i));
//            actualLinks.add(allLinkValues.get(i).getAttribute("href"));
//
//            Assert.assertTrue(actualLinks.get(i).contains("Default.aspx"));
//            Assert.assertTrue(actualLinks.get(i).contains("Products.aspx"));
//            Assert.assertTrue(actualLinks.get(i).contains("Process.aspx"));

        }
//        System.out.println(expectedLinks);
//        System.out.println(actualLinks);


        }

        /*
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11 /WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Click "Order" button
        Select product "Screen Saver"
        Input quantity 5
        Input Customer name "CodeFish IT School"
        Input Street "2200 E devon"
        Input City "Des Plaines"
        Input State "Illinois"
        Input Zip "60018"
        Select MasterCard
        Input card number "444993876233"
        Input expiration date "03/24"
        click process button
         */

    /*
    part 2:
    Validate text "New order has been successfully added." is displayed below the Process button.
    Click View all orders button
    Validate new order is added and all inputs are matching with new order
     */
        @Test
    public void testCase4() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

            WebElement usernameBox = driver.findElement(By.xpath("//input[@type='text']"));
            usernameBox.sendKeys("Tester");

            WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
            passwordBox.sendKeys("test");

            WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
            loginButton.click();

            WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
            orderButton.click();
            Thread.sleep(3000);

            WebElement productOptions = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
            BrowserUtils.selectBy(productOptions,"ScreenSaver","text");
            Thread.sleep(3000);

            WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
            quantityBox.sendKeys("5");

            WebElement customerNameBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
            customerNameBox.sendKeys("CodeFish IT School");

            WebElement streetBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
            streetBox.sendKeys("2200 E devon");

            WebElement cityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
            cityBox.sendKeys("Des Plaines");

            WebElement stateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
            stateBox.sendKeys("Illinois");

            WebElement zipBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
            zipBox.sendKeys("60018");

            WebElement cardButton = driver.findElement(By.xpath("//input[@value='MasterCard']"));
            cardButton.click();

            WebElement cardNumberBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
            cardNumberBox.sendKeys("444993876233");

            WebElement expiredDateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
            expiredDateBox.sendKeys("03/24");

            WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
            processButton.click();
            Thread.sleep(3000);

            //part2

            WebElement textBelowProcessButton = driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"));
            String actualText = BrowserUtils.getText(textBelowProcessButton);
            String expectedText ="New order has been successfully added.";
            Assert.assertEquals(actualText,expectedText);
            Thread.sleep(3000);

            WebElement viewAllOrdersLink = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]                "));
            viewAllOrdersLink.click();


            List<WebElement> newOrderInfo = driver.findElements(By.xpath("//tr[2]"));
            List<String> actualOrderInfo = new ArrayList<>();
            List<String> expectedInfo = new ArrayList<>();
            for(WebElement info : newOrderInfo){
                Assert.assertTrue(info.isDisplayed());
                actualOrderInfo.add(info.getText().trim().toLowerCase());
                expectedInfo.add(info.getText().trim().toLowerCase());
            }
            Collections.sort(expectedInfo);
            Collections.reverse(expectedInfo);
            Assert.assertEquals(actualOrderInfo,expectedInfo);
            System.out.println(actualOrderInfo);
            System.out.println(expectedInfo);







        }






}
