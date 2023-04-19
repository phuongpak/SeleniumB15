package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class HTMLPopUp {
    @Test
    public void htmlPopUpPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement previewForJS = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewForJS.click();
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Oops, something went wrong!");
        alert.accept();

        WebElement htmlButton = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        htmlButton.click();
        Thread.sleep(3000);

        WebElement text = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        Assert.assertTrue(BrowserUtils.getText(text).contains("Something went wrong!"));
        Thread.sleep(3000);
        driver.quit();




    }
}
