package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
        //SUNDAY 2/12
         //ID LOCATOR
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/davidmacbookpro13/Downloads/Techtorialhtml.html");

       // WebElement variable represent everything on the page
        WebElement header =driver.findElement( By.id("techtorial1") );//found header

        String actualHeader=header.getText().trim();//get the text of the value

        String expectedHeader ="Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println( actualHeader.equals(expectedHeader) ? "passed" : "failed");


        //task:get the paragraph

        WebElement paragraph = driver.findElement( By.id("details2") );
        System.out.println(paragraph.getText().trim());
        //String actualHeader1 = paragraph.getText().trim();//no need to store it if we just want to print it out

        //NAME LOCATOR

        WebElement firstName = driver.findElement( By.name("firstName") );//now we have access for the box
        firstName.sendKeys("PHUONG");//AFTER THIS, RUN THE CODE,IT WILL PUT YOUR NAME ON THAT BOX

        WebElement lastName = driver.findElement( By.name("lastName") );
        lastName.sendKeys("PAK");

        WebElement phone = driver.findElement( By.name("phone") );
        phone.sendKeys("123456789");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("pp@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("bbbbbbb");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Romeoville");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postCode = driver.findElement(By.name("postalCode"));
        postCode.sendKeys("60563");

        Thread.sleep(3000);

        //driver.close(); we have to use class locator down so we cannot use this close method


        //CLASS LOCATOR:
        WebElement checkboxLabel = driver.findElement(By.className("checkboxes"));
       System.out.println( checkboxLabel.getText() );

        WebElement javaBox = driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isSelected());//false
        if(javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected());//true

        WebElement SeleniumBox = driver.findElement(By.id("cond2"));
        if(SeleniumBox.isDisplayed() && !SeleniumBox.isSelected()){
            SeleniumBox.click();
        }
        System.out.println(SeleniumBox.isSelected());//true
        System.out.println(SeleniumBox.isDisplayed());//true

        WebElement TestNGBox = driver.findElement(By.id("cond3"));
        if(TestNGBox.isDisplayed() && !TestNGBox.isSelected()){
            TestNGBox.click();
        }

        WebElement CucumberBox = driver.findElement(By.id("cond4"));
        if(CucumberBox.isDisplayed() && !CucumberBox.isSelected()){
            CucumberBox.click();
        }

        //TAG NAME LOCATOR:

        WebElement version = driver.findElement(By.tagName("u"));

        String actualVersion =version.getText().trim();

        String expectedVersion ="Use Java Version";
        if(actualVersion.equals(expectedVersion)){//compare 2 value: one from your, one from system
            System.out.println("Validation is passed");
        }else{
            System.out.println("Validation is failed");
        }







    }
}
