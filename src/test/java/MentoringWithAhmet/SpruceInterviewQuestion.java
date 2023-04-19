package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;

public class SpruceInterviewQuestion {
    @Test
    public void validateFishProduct() throws InterruptedException {
            /*
    1-Navigate to the website "https://www.thespruceeats.com/"
    2-Under Ingredients option --> choose Fish&SeaFood option (user hover over)
    3-ScrollDown to the search bar
    4-Send the data: "Food for dinner"
    5-On the left side choose 4 star up option
    6-From popular: Choose the Editor's choice option
    7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
    8-Quit or close your driver

    Purpose: apply action class method
    apply how to find the unique element for real website
    apply JS scroll method
    apply testNG Assertion (
    appy
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.thespruceeats.com/");

        WebElement ingredientLink = driver.findElement(By.xpath("//a[@class='global-nav__list-item-link']//span[contains(text(),'Ingredients')]"));
       Actions actions = new Actions(driver);
       actions.moveToElement(ingredientLink).perform();

       WebElement fishAndSeaFood = driver.findElement(By.xpath("//a[contains(text(),'Fish & Seafood')]"));
       actions.click(fishAndSeaFood).perform();
        Thread.sleep(3000);
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search-form-input']"));

        BrowserUtils.scrollWithJS(driver,searchBar);
        Thread.sleep(3000);
        searchBar.sendKeys("Fish for dinner",Keys.ENTER);


        WebElement fourStar = driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        fourStar.click();

        WebElement editorsChoice = driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        editorsChoice.click();

        Thread.sleep(3000);

        WebElement nameOfProduct = driver.findElement(By.xpath("//span[contains(text(),'Salmon Fillets')]"));
//        String actualName = BrowserUtils.getText(nameOfProduct);
//        String expectedName ="6-Ingredient Roasted Salmon Fillets";
       // Assert.assertEquals(actualName,expectedName);
        Assert.assertEquals(BrowserUtils.getText(nameOfProduct),"6-Ingredient Roasted Salmon Fillets");


        driver.quit();




    }
}
