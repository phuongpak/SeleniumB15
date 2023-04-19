package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.plaf.basic.BasicSliderUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SeleniumHomework3 {

    @Test
    public void testCase2Part1() throws InterruptedException {
        /*
         Navigate to the "http://uitestpractice.com/Students/Index"
        Click "Create New" button
        Enter any firstname, lastname and enrollment date
        Click create button
        Search firstname in search bar
        Validate the new information is created
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");

        WebElement createNewButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        createNewButton.click();
        Thread.sleep(3000);


        WebElement iframeAd = driver.findElement(By.cssSelector("#aswift_2"));
        driver.switchTo().frame(iframeAd);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ad_iframe']"));
        driver.switchTo().frame(iframe);

        Thread.sleep(4000);

        WebElement closeButton = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        closeButton.click();
        BrowserUtils.switchByTitle(driver, "Testing Controls - UI Automation Demo Site");
        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.sendKeys("PHUONG");

        WebElement lastName = driver.findElement(By.cssSelector("#LastName"));
        lastName.sendKeys("PAK");

        WebElement enrolmentDate = driver.findElement(By.xpath("//input[@id='EnrollmentDate']"));
        enrolmentDate.sendKeys("11/14/2022");

        WebElement createButton = driver.findElement(By.xpath("//input[@value='Create']"));
        createButton.click();

        WebElement searchBar = driver.findElement(By.cssSelector("#Search_Data"));
        searchBar.sendKeys("PHUONG");

        WebElement findButton = driver.findElement(By.xpath("//input[@type='submit']"));
        findButton.click();

        List<WebElement> allInfo = driver.findElements(By.xpath("//dl[@class='dl-horizontal']"));
        List<String> expectedInfo = Arrays.asList("FirstName PHUONG", "LastName PAK", "EnrollmentDate 11/14/2022 12:00:00 AM");
        for (int i = 0; i < allInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)), expectedInfo.get(i));


        }

        driver.close();
    }
    @Test
    public void TestCase2Part2() throws InterruptedException {
        /*
            Navigate to the "http://uitestpractice.com/Students/Index"
            Search your Lastname in search bar
            Click Edit button
            Change first name
            Click save button
            Search with new firstname
            Validate Firstname is changed
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        //Search your Lastname in search bar
        WebElement searchNameBox = driver.findElement(By.cssSelector("#Search_Data"));
        searchNameBox.sendKeys("PAK");
        WebElement findButton = driver.findElement(By.xpath("//input[contains(@value,'Find')]"));
        //findButton.click();
        findButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        //Click Edit button
        WebElement editButton = driver.findElement(By.xpath("//button[contains(text(),'EDIT')]"));
        editButton.click();
        //    Change first name
        WebElement firstNameBox = driver.findElement(By.xpath("//input[contains(@name,'FirstName')]"));
        firstNameBox.clear();
        firstNameBox.sendKeys("KATE");
        //    Click save button
        WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit']"));
        saveButton.click();
        //    Search with new firstname
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.cssSelector("#Search_Data"));
        searchBox.sendKeys("KATE");
        findButton = driver.findElement(By.xpath("//input[contains(@value,'Find')]"));
        findButton.click();
        //    Validate Firstname is changed
        WebElement firstNameChange = driver.findElement(By.xpath("//td[contains(text(),'KATE')]"));
        Assert.assertFalse(firstNameChange.getText().contains("PHUONG"));
        driver.close();


    }
    @Test
    public void testCase3() throws InterruptedException {
       /*
           Navigate to the "http://uitestpractice.com/Students/Index"
           Search any Lastname in search bar
        Click delete button
            Confirm delete function
        Search with same lastname
            Validate "There are zero students with this search text Page 0 of 0" after deleting the user
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");

        WebElement searchNameBox = driver.findElement(By.cssSelector("#Search_Data"));
        searchNameBox.sendKeys("cheng");
        WebElement findButton = driver.findElement(By.xpath("//input[contains(@value,'Find')]"));
        findButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'DELETE')]"));
        deleteButton.click();

        WebElement confirmDeleteFunction = driver.findElement(By.xpath("//input[@type='submit']"));
        confirmDeleteFunction.click();
        Thread.sleep(3000);

        WebElement searchNameBoxAfterDeleting = driver.findElement(By.cssSelector("#Search_Data"));
        searchNameBoxAfterDeleting.sendKeys("cheng");

        WebElement findButtonAfterDeleting = driver.findElement(By.xpath("//input[contains(@value,'Find')]"));
        findButtonAfterDeleting.click();

        WebElement message = driver.findElement(By.xpath("//div[@class='container body-content']"));
        Assert.assertEquals(BrowserUtils.getText(message),"\n" +
                "There are zero students with this search text\n" +
                "    Page 0 of 0\n" +
                "    ");
        driver.quit();
    }
    @Test
    public void testCase4(){
        /*
        Navigate to the "http://uitestpractice.com/"
        Move small box into the Drop Here box
         Validate text "Dropped" displayed
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/");

        WebElement dropBox = driver.findElement(By.xpath("//div[@class='container green']//div[2]"));
        WebElement dragger = driver.findElement(By.xpath("//div[@class='container green']//div[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragger,dropBox).perform();

        WebElement message = driver.findElement(By.xpath("//div[@id='droppable']//p"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void testCase5() throws InterruptedException {
        /*
        Navigate to the "http://uitestpractice.com/"
        Click two times Double click button
        Validate Alert has "Double Clicked !!" text
        Click Okay button to close the alert
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/");

        WebElement doubleClicKButton = driver.findElement(By.xpath("//button[.='Double Click ME !']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClicKButton).perform();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Double Clicked !!");
        alert.accept();
        driver.quit();

    }

        @Test
      public void testCase6() throws InterruptedException {

                /*
             Navigate to the "http://uitestpractice.com/"
            Enter your name inside the iframe
            Click the link inside the Iframe box
            Validate "www.uitestpractice.com refused to connect." is displayed
                     */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.navigate().to("http://uitestpractice.com/");
            Thread.sleep(3000);

            WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
            driver.switchTo().frame(iframe);

            WebElement nameBox = driver.findElement(By.xpath("//label[contains(text(),'Enter your name:')]//following-sibling::input"));
           // BrowserUtils.scrollWithJS(driver,nameBox);
            nameBox.sendKeys("PHUONG");

            Thread.sleep(3000);
            driver.switchTo().parentFrame();

            WebElement link = driver.findElement(By.xpath("//a[contains(text(),'uitestpractice')]"));
            BrowserUtils.scrollWithJS(driver,link);
            Thread.sleep(3000);
            //link.click();
            BrowserUtils.clickWithJS(driver,link);

            WebElement iframeMessage = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
            driver.switchTo().frame(iframeMessage);

            WebElement message = driver.findElement(By.xpath("//div[@id='sub-frame-error']"));


            Actions actions =new Actions(driver);
            actions.moveToElement(message).perform();
            Assert.assertTrue(message.isDisplayed());
            System.out.println(message.getText().trim());
            driver.quit();

        }
            @Test
        public void testCase7() throws InterruptedException {
        /*
        Navigate to the "http://uitestpractice.com/"
        Click on the below button to open link in new Window
         Validate Title contains "C# Beginner to advanced" text
         Validate the link has youtube text in new window
         */
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.navigate().to("http://uitestpractice.com/");

                WebElement belowButtonLink = driver.findElement(By.xpath("//div[@class='container Compli']//a"));
                belowButtonLink.click();

                Thread.sleep(3000);
                System.out.println(driver.getTitle());
                //first way:
                BrowserUtils.switchByTitle(driver,"(36) C# Beginner to advanced");
                //other way:
//                String mainPageId = driver.getWindowHandle();
//                Set<String> allPageIDs = driver.getWindowHandles();
//                for(String id: allPageIDs){
//                    if(!id.equals(mainPageId)){
//                        driver.switchTo().window(id);
//                    }
//                }
                Assert.assertTrue(driver.getTitle().contains("C# Beginner to advanced"));
                Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
                driver.quit();

            }









































}
