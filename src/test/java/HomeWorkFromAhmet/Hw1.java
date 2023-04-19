package HomeWorkFromAhmet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hw1 {
    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver","chromedriver");

        //etsy.com
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.etsy.com/");
        System.out.println(driver1.getTitle());

        String actualTitle1 = driver1.getTitle();
        String expectedTitle1 ="Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        if(actualTitle1.equals(expectedTitle1)){
            System.out.println("Test1 is passed");
        }else{
            System.out.println("Test1 is failed");
        }

        //https://www.starbucks.com/

        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get("https://www.starbucks.com/");
        System.out.println(driver2.getTitle());

        String actualTitle2 = driver2.getTitle();
        String expectedTitle2 ="Starbucks Coffee Company";
        if(actualTitle2.equals(expectedTitle2)){
            System.out.println("Test2 is passed");
        }else {
            System.out.println("Test2 is failed");
        }


        //https://www.ebay.com/

        WebDriver driver3 = new ChromeDriver();
        driver3.manage().window().maximize();
        driver3.get("https://www.ebay.com/");
        System.out.println(driver3.getTitle());

        String actualTitle3 = driver3.getTitle();
        String expectedTitle3 ="Electronics, Cars, Fashion, Collectibles & More | eBay";

        if(actualTitle3.equals(expectedTitle3)){
            System.out.println("Test3 is passed");
        }else{
            System.out.println("Test3 is failed");
        }




    }
}
