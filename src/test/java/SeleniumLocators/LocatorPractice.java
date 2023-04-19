package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {
        //http://tutorialsninja.com/demo/index.php?route=account/register


        //1-set up automation

        System.setProperty("webdriver.chrome.driver" ,"chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        //2-Automation process
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));//@ MEANS ATTRIBUTE
        firstName.sendKeys("Phuong");
            //task: find last name element by "using name" by xpath
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Pak");
            //task:using placeholder
        WebElement placeHolder = driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        placeHolder.sendKeys("ppppppp12@gmail.com");
            //using type
        WebElement telephone=driver.findElement(By.xpath("//input[@type='tel']"));//make sure it is unique 1 of 1
        telephone.sendKeys("123456");

            //using class name but not unique so use id
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("pp1234");

        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("pp1234");

        WebElement privacyButton = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyButton.click();

        WebElement continueButton =driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader =header.getText().trim();
        String expectedHeader ="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header passed" : "Header failed");
       driver.quit();



    }
}
