package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)

    public static void main(String[] args) {
        //read the task carefully
        //1-setup your automation

      System.setProperty("webdriver.chrome.driver","chromeDriver");
      //2-Create your driver object
      WebDriver driver = new ChromeDriver();
      //3-go to website and maximize your screen
      driver.manage().window().maximize();//maximize
        driver.get("https://www.godaddy.com/");//get title

       //4-following the steps from task

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl ="https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "Url passed" : "Url failed");

        String actualTitle = driver.getTitle();//comes from system
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        System.out.println( actualTitle.equals(expectedTitle) ? "Title passed" : "Title failed");

//        if(actualUrl.equals(expectedUrl)){
//            System.out.println("Url is passed");
//        }else{
//            System.out.println("Url is failed");
//        }
//        if(actualTitle.equals(expectedTitle)){
//            System.out.println("Title is passed");
//
//        }else{
//            System.out.println("Title is failed");
//        }

        driver.close();








    }










}
