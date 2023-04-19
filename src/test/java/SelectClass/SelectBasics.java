package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectBasics {

    //SELECT CLASS IS ALL ABOUT DROP DOWN
    //Drop box must have

    @Test
    public void practiceSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();

        //location of the box
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(optionBox);//provide loation of the box inside of select object
        System.out.println(options.getFirstSelectedOption().getText().trim());//we use it before we touch anything
        options.selectByValue("1");//value of option 1 is 1
        Thread.sleep(3000);
        options.selectByVisibleText("Option 2");//by visible text//text of option 2 is >Option 2<
        Thread.sleep(3000);
        options.selectByIndex(1);//
        Thread.sleep(3000);
        //System.out.println(options.getFirstSelectedOption().getText().trim());if we use it here, it will show option 1
        //cuz option 1 is the firstselectedoption after line 38

        List<WebElement> allOptions =options.getOptions();//get all options from the list
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1","Option 2");
        for(int i =0; i< allOptions.size();i++){
            Assert.assertEquals(allOptions.get(i).getText().trim() , expectedOptions.get(i));
        }


        }

    @Test
    public void validateFirstOptionAndPrintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///Users/davidmacbookpro13/Downloads/Techtorialhtml.html");
        //validated united state as default

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);
        String actualFirstOption = country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption ="UNITED STATES";
        Assert.assertEquals(actualFirstOption, expectedFirstOption);
            //get all countries options; getOptions in the List
        List<WebElement> allTheCountryOptions = country.getOptions();
        int counter =0;
        for(WebElement countryName : allTheCountryOptions){
            System.out.println(countryName.getText().trim());
            counter++;
        }
        System.out.println(counter);

        //first:index
                //second:value
                //three: visible

       country.selectByIndex(4);//ANGOLA//NOT REALLY RELIABLE
       Thread.sleep(3000);
       country.selectByValue("259");
       Thread.sleep(3000);
       country.selectByVisibleText("VIETNAM ");


    }

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
        WebDriver driver =new ChromeDriver();
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
        String expectedDepartCountry ="Acapulco";
        Assert.assertEquals(actualDepartCountry,expectedDepartCountry);

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

        WebElement monthReturningBox= driver.findElement(By.xpath("//select[@name='toMonth']"));
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
        List<String> expectedOptions =Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

      for(int i =0;i<allActualAirlineOptions.size();i++){
          Assert.assertEquals(allActualAirlineOptions.get(i).getText().trim() , expectedOptions.get(i));
      }


        airline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = message.getText().trim();
        String expectedMessage ="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);//failed cuz "Available word spell wrong,
        // take a screenshot of the different in console and
        //a screenshot of the inspection of that element







}









}
