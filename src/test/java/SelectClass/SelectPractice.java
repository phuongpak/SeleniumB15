package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {
          /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerBox = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passengerBox);
        passenger.selectByValue("4");

        WebElement departingBox = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select country = new Select(departingBox);
        String actualDepartCountry = country.getFirstSelectedOption().getText().trim();
        String expectedDepartCountry = "Acapulco";
        Assert.assertEquals(actualDepartCountry, expectedDepartCountry);

        country.selectByIndex(4);//paris


        WebElement monthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select month = new Select(monthBox);
        month.selectByVisibleText("August");

        WebElement dateLeavingBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dateLeave = new Select(dateLeavingBox);
        dateLeave.selectByVisibleText("15");

        WebElement arrivingBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrive = new Select(arrivingBox);
        arrive.selectByVisibleText("San Francisco");

        WebElement monthReturningBox = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select monthReturn = new Select(monthReturningBox);
        monthReturn.selectByValue("12");

        WebElement dateReturningBox = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select dateReturn = new Select(dateReturningBox);
        dateReturn.selectByValue("15");

        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        Thread.sleep(3000);

        //validate all options//assert compare //only 4 option so do aslist//
        WebElement airlineBox = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline = new Select(airlineBox);

        List<WebElement> allActualAirlineOptions = airline.getOptions();//4 options
        List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < allActualAirlineOptions.size(); i++) {
            Assert.assertEquals(allActualAirlineOptions.get(i).getText().trim(), expectedOptions.get(i));
        }


        airline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage, expectedMessage);//failed cuz "Available word spell wrong,
        // take a screenshot of the different in console and
        //a screenshot of the inspection of that element


    }

    @Test
    public void multiSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///Users/davidmacbookpro13/Downloads/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.cssSelector(".select"));
        Select country = new Select(countryBox);
        country.selectByVisibleText("One");
        Thread.sleep(3000);
        country.selectByValue("3");
        Thread.sleep(3000);
        country.selectByIndex(4);
        Thread.sleep(2000);

        country.deselectByVisibleText("One");
        //country.deselectByValue("1");
        Thread.sleep(3000);
        country.deselectAll();

    }

    @Test
    public void shortCutSelected() throws InterruptedException {


          /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerBox = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerBox,"4","value");


        WebElement departingBox = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select country = new Select(departingBox);
        String actualDepartCountry = country.getFirstSelectedOption().getText().trim();
        String expectedDepartCountry = "Acapulco";
        Assert.assertEquals(actualDepartCountry, expectedDepartCountry);

        BrowserUtils.selectBy(departingBox,"4","index");

        WebElement monthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(monthBox,"August","text");

        WebElement dateLeavingBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dateLeavingBox,"15","text");

        WebElement arrivingBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivingBox,"San Francisco","text");

        WebElement monthReturningBox = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(monthReturningBox,"12","value");

        WebElement dateReturningBox = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(dateReturningBox,"15","value");

        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        Thread.sleep(3000);

        //validate all options//assert compare //only 4 option so do aslist//
        WebElement airlineBox = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline = new Select(airlineBox);

        List<WebElement> allActualAirlineOptions = airline.getOptions();//4 options
        List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < allActualAirlineOptions.size(); i++) {
            Assert.assertEquals(allActualAirlineOptions.get(i).getText().trim(), expectedOptions.get(i));
        }

        airline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        //String actualMessage = message.getText().trim();//it works, just do different way

        String actualMessage = BrowserUtils.getText(message);//call method
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage, expectedMessage);//failed cuz "Available word spell wrong,
        // take a screenshot of the different in console and
        //a screenshot of the inspection of that element


    }


}
