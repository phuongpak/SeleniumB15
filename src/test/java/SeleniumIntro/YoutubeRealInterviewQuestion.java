package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    /* 1-Navigate to the website youtube
 2-Search for justin bieber
 3-Find the all song names and store in the list Justin Bieber - Hold On (Live from Paris)
 4-Use for and if conditions to find the song
 5-Click the song
 6-Enjoy your music
 7-Ready to be level 2
 */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com/");

        //search for justin bieber
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Justin Bieber songs");

        //shortcut: searchBox.sendKeys(Keys.ENTER)
        //click button
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        Thread.sleep(3000);


        List<WebElement> allSongs = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song : allSongs) {
            song.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(3000);

            if (song.getAttribute("title").trim().equals("Justin Bieber - Ghost")) {
                song.click();
                break;

            }


        }
    }
}
