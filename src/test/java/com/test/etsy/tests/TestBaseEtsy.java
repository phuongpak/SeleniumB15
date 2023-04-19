package com.test.etsy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseEtsy {

    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
       driver= DriverHelper.getDriver();
       driver.get(ConfigReader.readProperty("etsyUrl"));

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"etsy");
        driver.quit(); //command it during doing test, after all pass, activate it (open it)
    }
}
