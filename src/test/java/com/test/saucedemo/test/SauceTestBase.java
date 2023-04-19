package com.test.saucedemo.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SauceTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("QA_sauceUrl"));
    }



    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"sauce");
        driver.quit();
    }


}
