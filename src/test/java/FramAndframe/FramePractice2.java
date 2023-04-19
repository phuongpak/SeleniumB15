package FramAndframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {


    @Test
    public void practiceFrame() throws InterruptedException {
            /*
    TASK 1:
      1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
      2-Click pavilion (new tab will be opened, consider switch window)
      3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
      4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
      5-Print out(NO validation) Table of Content options on console(loop and getText())
      6-Wait for Second task


        TASK 2:
        1-Go back to the main page "iframe"
        2-click category 1
        3-Validate the header "Category Archives: SeleniumTesting"
        4-Print out all the headers of the contents(i will show you)

 */



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        //2
        WebElement pavilionLink = driver.findElement(By.linkText("Pavilion"));
        pavilionLink.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");

        WebElement seleniumButton = driver.findElement(By.xpath("//li[@class='menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-160 has-children depth-0']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumButton).perform();

        WebElement seleniumJavaOption = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[contains(text(),'Selenium-Java')]"));
        ////ul[@id='primary-menu']//span[.='Selenium-Java']
        seleniumJavaOption.click();

        WebElement header = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(header), "Selenium-Java Tutorial – Basic to Advance");

        List<WebElement> tableOfContent =driver.findElements(By.cssSelector(".ht_toc_list"));

        for(WebElement content : tableOfContent){
            System.out.println(BrowserUtils.getText(content));

        }
        BrowserUtils.switchByTitle(driver,"iframes");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='Frame1']"));

        driver.switchTo().frame(iframe);

        WebElement category1Link = driver.findElement(By.xpath("//a[contains(text(),'Category1')]"));
        category1Link.click();

        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");

        WebElement categoryHeader = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(categoryHeader) , "Category Archives: SeleniumTesting");

        List<WebElement> allHeaders = driver.findElements(By.xpath("//h3"));
        for(WebElement header2 : allHeaders){
            System.out.println(BrowserUtils.getText(header2));
        }
        /*
        task3:

         */
        BrowserUtils.switchByTitle(driver,"iframes");
        WebElement iframe2 =driver.findElement(By.xpath("//iframe[@id='Frame2']"));
        driver.switchTo().frame(iframe2);

        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement CategoryHeader = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(CategoryHeader), "Category Archives: SoftwareTesting");

        driver.quit();








    }
}
