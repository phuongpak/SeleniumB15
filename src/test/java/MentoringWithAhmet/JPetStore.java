package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPetStore {

    /*
    1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
    2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
    3-Go to the main menu and choose 2 different category and choose one item from there
    4-Add them into the card
    5-Validate the total cost equals to the price at the bottom shows.
    6-Quit

 */
    @Test
    public void validateCostMathFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");

        //2
        WebElement fishCategory = driver.findElement(By.xpath("//div[@id='QuickLinks']//a[1]"));
        fishCategory.click();

        List<WebElement> allProductIDS = driver.findElements(By.xpath("//tbody//tr//td[1]"));
        List<WebElement> allNames = driver.findElements(By.xpath("//tbody//tr//td[2]"));
        Map<String, String> listOfFishes = new HashMap<>();
        for(int i = 0; i<allProductIDS.size();i++){
            listOfFishes.put(BrowserUtils.getText(allProductIDS.get(i)) ,BrowserUtils.getText(allNames.get(i)));

        }
        System.out.println(listOfFishes);

        //3
        driver.navigate().back();//back to main menu
        WebElement dogCategory = driver.findElement(By.xpath("//div[@id='QuickLinks']//a[2]"));
        dogCategory.click();
        WebElement goldenRetriever = driver.findElement(By.xpath("//td[.='Golden Retriever']//preceding-sibling::td//a"));
        goldenRetriever.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector(".Button"));
        addToCartButton.click();

        WebElement birdsCategory = driver.findElement(By.xpath("//div[@id='QuickLinks']//a[5]"));
        birdsCategory.click();
        WebElement amazonParrot = driver.findElement(By.xpath("//td[.='Amazon Parrot']//preceding-sibling::td//a"));
        amazonParrot.click();
        Thread.sleep(3000);
        WebElement addToCartButtonForBirdsCategory = driver.findElement(By.linkText("Add to Cart"));
        addToCartButtonForBirdsCategory.click();

        WebElement totalCost = driver.findElement(By.xpath("//td[contains(text(),'Sub Total')]"));

        Assert.assertEquals(BrowserUtils.getText(totalCost),"Sub Total: $348.79");
        driver.quit();



    }

}
