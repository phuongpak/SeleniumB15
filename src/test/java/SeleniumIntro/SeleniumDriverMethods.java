package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    //driver.get()
    //driver.manage().windows.maximize()

    //driver.getTitle()
    //driver.getCurrentUrl

    //driver.getPageSource()
    //driver.navigateTo()
    //driver.navigate.refresh()
    //driver.navigate.forward()
    //driver.navigate.back()
    //driver.close()

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());

        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());

       Thread.sleep(3000);//make the system run slower 3 seconds
        driver.navigate().back();//means go to previous page which is google
       Thread.sleep(3000);
        driver.navigate().forward();//youtube
       Thread.sleep(3000);
        driver.navigate().refresh();//refresh the page
        Thread.sleep(3000);
       // driver.quit();//close all automation pages
        System.out.println(driver.getPageSource());//it will give the html structure of page
        driver.close();



    }



}
