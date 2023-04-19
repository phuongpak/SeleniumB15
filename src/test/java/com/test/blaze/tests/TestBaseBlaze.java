package com.test.blaze.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class TestBaseBlaze {
//IS A WAY TO STORE BEFORE METHOD AND AFTER METHOD ANATATION


    public WebDriver driver;//MAKE IT ACCESSIBLE TO EVERYWHERE SO WE ADDED PUBLIC
    @BeforeSuite
    public void clearTheCaches(){
        driver=DriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod
    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver = DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");

    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"blazePicture");
        }
        driver.quit();

    }
}
