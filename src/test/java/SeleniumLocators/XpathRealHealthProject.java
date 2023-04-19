package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {
     /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment

THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

      */


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");


        //WebElement makeAppointment =driver.findElement(By.xpath("//html/body/header/div/a"));
        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();


        WebElement firstName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        firstName.sendKeys("John Doe");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='txt-password']"));
        lastName.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement applyButton = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (applyButton.isDisplayed() && !applyButton.isSelected()) {
            applyButton.click();
        }

        WebElement HealthCareProgramCheck = driver.findElement(By.xpath("//input[@id='radio_program_medicare']"));
        HealthCareProgramCheck.click();

        WebElement visitedDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitedDate.sendKeys("01/02/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@placeholder='Comment']"));
        comment.sendKeys("comment here");

        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();

        WebElement appointmentHeader = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = appointmentHeader.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        //USING TERNARY OR IF
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Appointment passed");
            System.out.println(actualHeader);
        } else {
            System.out.println("Appoint failed");
        }


        WebElement homepageButton = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        homepageButton.click();

        System.out.println(driver.getCurrentUrl().trim());
        Thread.sleep(3000);
        driver.close();


    }

}
