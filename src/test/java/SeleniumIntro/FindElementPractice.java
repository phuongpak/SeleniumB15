package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementPractice {
    //https://the-internet.herokuapp.com/
    //print out all the link
    //print out only ones have more than equal 12 length
    public static void main(String[] args) {


        System.setProperty("Webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");


        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));//44 elements
        int counter1 =0;
        for(WebElement link :allLinks){
            System.out.println("" + link.getText().trim());
            counter1++;
        }
        System.out.println(counter1);//44
        System.out.println(allLinks.size());//44

        //print out the words letters more than equal 12
        int counter2=0;
        for(WebElement link :allLinks){
            if(link.getText().trim().length()>=12){
                System.out.println(link.getText().trim());
                counter2++;//
            }
        }

        System.out.println(counter2);












    }
}
