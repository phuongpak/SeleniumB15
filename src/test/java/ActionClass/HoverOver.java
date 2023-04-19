package ActionClass;

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
import java.util.*;

public class HoverOver {

    @Test
    public void validateNamesFromPictures() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allUserNames = driver.findElements(By.xpath("//h5"));
        List<WebElement> images =driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");

        Actions actions = new Actions(driver);

        for(int i =0; i< allUserNames.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform();//YOU ARE HOVER OVERING THE PICTURES
            actualNames.add(BrowserUtils.getText(allUserNames.get(i)));//YOU ARE STRONG THE NAMES INSIDE OF THE LIST FOR VALIDATION

        }
        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);

    }
    /*

    1-Navigate to the website
    2-If you have cookies pop-up then click
    3-Hover over each pictures and get the names and store it in List<String> allNames
    4-Hover over each pictures and get the prices and store it in List<String> all prices
    5-Put them all of the names as key of map, and all of the prices as value of map
    6-Print out map

    CLUES:You can use 1 regular(indexing) loop for adding the name and prices into the lists
    CLUES:You can use same loop for putting into the map
    CLUES:TO ab ele to get names and prices you need to hover over first
    CLUES:DO not forget perform
     */


    @Test
    public void practiceMoveToElement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        //2-
        WebElement acceptsCookieButton = driver.findElement(By.xpath("//button[contains(text(),'Accept Cookies')]"));
//        acceptsCookieButton.click();//second way down
        Actions actions = new Actions(driver);//if use this action,we do not need to have another action down line 82 before loop
        actions.click(acceptsCookieButton).perform();
        //find location

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));

        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product k-listview-item']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product k-listview-item']//p"));



        actions.scrollByAmount(300,300);

        Map<String, String>  map = new HashMap();
//        Actions actions = new Actions(driver);
        for(int i= 0; i< images.size(); i++){
            actions.moveToElement(images.get(i)).perform();
            map.put( BrowserUtils.getText(allNames.get(i) ), BrowserUtils.getText(allPrices.get(i) ) );


        }
        System.out.println(map);

    }







}
