package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class OrderTest extends TestBaseBlaze{
//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//
//    }
    @DataProvider(name="customerInfo")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Turkey","Ankara","123455","12","2025"},
                {"John","USA","Chicago","123478","5","2029"},
                {"Phuong Pak","Vietnam","Saigon","3324768","3","2029"}


    };

}

    @Test(dataProvider = "customerInfo")
    public void validateOrderFunctionality(String name, String country, String city,String creditCart,
                                           String month, String year) throws InterruptedException {
        MainPage mainPage =new MainPage(driver);
        mainPage.clickLaptop();
        LapTopPage lapTopPage =new LapTopPage(driver);
        Thread.sleep(3000);
        lapTopPage.clickMacBookPro("MacBook Pro");
        MacBookPage macBookPage=new MacBookPage(driver);
        macBookPage.clickAddToCartButton(driver,"Product added");

        mainPage.clickCart();
        CartPage cartPage =new CartPage(driver);
        cartPage.validateProductInfo("MacBook Pro","1100");

        OrderPage orderPage =new OrderPage(driver);
        orderPage.clickOrderButton();
        orderPage.validateOrderFunctionality
                (name,country,city,creditCart,month,year,"Thank you for your purchase!");

        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");//
                    //that line is validate after click ok purchase, it goes back to main page
    }

}
