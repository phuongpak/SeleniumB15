package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement location, String value, String methodName){

        Select select = new Select(location);

        switch(methodName){

            case "text":
                select.selectByVisibleText(value);
                break;//do not ever forget break
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));//;parsing object to int
                break;
            default:
                System.out.println("Method name is not available, use text, value or index");
        }

    }

    public static String getText(WebElement element){

      return element.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();

    }

    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);


    }

    public static void switchById(WebDriver driver){
        String mainPageId = driver.getWindowHandle();
        Set<String> allPageId = driver.getWindowHandles();
        for(String id: allPageId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String title){
        Set<String> allPageID = driver.getWindowHandles();
        for(String id : allPageID){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void getScreenShot(WebDriver driver, String packageName) {
        //take screenshot whenever something is failed

        File file =( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String location = System.getProperty("src/test/java/" +packageName+"/");

        try{
            FileUtils.copyFile(file, new File(location+System.currentTimeMillis()));
        }catch (IOException e){
            throw new RuntimeException();
        }

    }
}