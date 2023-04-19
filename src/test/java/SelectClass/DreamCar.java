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
import java.util.Collections;
import java.util.List;

public class DreamCar {

/*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */

    @Test
    public void validateHeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        //2-
        WebElement newUsedBox = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsedBox, "New", "text");
        //3-
        WebElement makeBox = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeBox, "Lexus", "text");
        //4-
        WebElement modelBox = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelBox, "RX 350", "text");
        //5-VALIDATE
        WebElement priceBox = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select price = new Select(priceBox);
        String actualPrice = price.getFirstSelectedOption().getText().trim();
        String expectedPrice = "No max price";
        Assert.assertEquals(actualPrice, expectedPrice);
        //6-
        WebElement locationBox = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(locationBox, "3", "index");
        //7-
        WebElement zipBox = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipBox.clear();
        zipBox.sendKeys("60446");
        Thread.sleep(3000);
        //8-
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();

        //9
        WebElement header =driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));

        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader ="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        //10-
        WebElement sortByBox = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortByBox,"Lowest price","text");
        //11-
        List<WebElement> allTitleNames = driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement title:allTitleNames){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));

        }

        List<String> numbers = Arrays.asList("1","2","3","5","4");
        List<Integer> numbers2 = Arrays.asList(1,2,3,5,4);

        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.sort(numbers2);
        System.out.println(numbers2);



    }


















    }


