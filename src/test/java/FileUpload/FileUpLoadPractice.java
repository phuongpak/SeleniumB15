package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUpLoadPractice {

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("/Users/davidmacbookpro13/Desktop/SDET/usa.png");

        WebElement fileUploadButton = driver.findElement(By.cssSelector(".button"));
       // fileUploadButton.click();//cuz it has type=submit
        fileUploadButton.submit();

        WebElement attachment = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(attachment),"usa.png");


    }

    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement choseFileButton = driver.findElement(By.cssSelector("#uploadfile_0"));
        choseFileButton.sendKeys("/Users/davidmacbookpro13/Desktop/SDET/brownbear.png");

        WebElement message = driver.findElement(By.xpath("//b[contains(text(),'Select file to send(max 196.45 MB)')]"));
                                                            ////div[@id='uploadmode3']//following-sibling::span//b

        Assert.assertEquals(BrowserUtils.getText(message),"Select file to send(max 196.45 MB)");

        WebElement acceptCheckBox = driver.findElement(By.xpath("//input[contains(@type,'checkbox')]"));
                                                                ////a[.='terms of service']//preceding-sibling::input
        acceptCheckBox.click();

        WebElement submitFileButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFileButton.click();


        WebElement messageAfterUploading = driver.findElement(By.xpath("//center[contains(text(),'1 file')]"));
        Assert.assertEquals(BrowserUtils.getText(messageAfterUploading),"1 file\n" +
                "has been successfully uploaded.");

        driver.quit();



    }



}
