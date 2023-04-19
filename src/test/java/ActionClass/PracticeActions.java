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

public class PracticeActions {

    @Test
    public void validateMessageAndColor() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        //GO TO BOX LOCATION
        WebElement whiteBox= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[2]"));
                                                                    //"//div[@id='simpleDropContainer']//div[@id='droppable']"
        //VALIDAT MESSAGE OF BOX
        String actualMessage = BrowserUtils.getText(whiteBox);
        String expectedMessage ="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);


        //drag
        WebElement dragger = driver.findElement(By.xpath("//div[contains(text(),'Drag me')]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragger,whiteBox).perform();//REMEMBER PERFORM

        whiteBox= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[2]"));

        String actualMessageAfterDropAndDrag =BrowserUtils.getText(whiteBox);
        String expectedMessageAfterDropAndDrag ="Dropped!";
        Assert.assertEquals(actualMessageAfterDropAndDrag,expectedMessageAfterDropAndDrag);

        //Validate color after drag and drop
        String actualColor = whiteBox.getCssValue("background-color");
        String expectedColor ="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void validateNotAcceptableFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement acceptButton = driver.findElement(By.xpath("//a[contains(text(),'Accept')]"));
        acceptButton.click();

        Thread.sleep(3000);

        WebElement box = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        String actualBoxName = BrowserUtils.getText(box);
        String expectedBoxName ="Drop here";
        Assert.assertEquals(actualBoxName,expectedBoxName);


        WebElement notAcceptableDragger = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='notAcceptable']"));
       String actualName =BrowserUtils.getText(notAcceptableDragger);
       String expectedName ="Not Acceptable";
       Assert.assertEquals(actualName,expectedName);

        Actions actions = new Actions(driver);
        actions.clickAndHold(notAcceptableDragger).moveToElement(box).release().perform();
        String actualMessageAfterClickAndHold = BrowserUtils.getText(box);
        String expectedMessageAfterClickAndHold ="Drop here";
        Assert.assertEquals(actualMessageAfterClickAndHold,expectedMessageAfterClickAndHold);





    }





}
