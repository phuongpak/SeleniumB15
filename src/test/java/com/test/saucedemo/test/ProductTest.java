package com.test.saucedemo.test;

import com.test.saucedemo.pages.CheckOutPage;
import com.test.saucedemo.pages.ProductPage;
import com.test.saucedemo.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductTest extends SauceTestBase{



    @Test(dataProvider ="TestingProductLinks",dataProviderClass = AllData.class)
    public void validateAllProductLinksAreWorking(String productName, String expectedDesc, String expectedPrice){
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));

        ProductPage productPage = new ProductPage(driver);
        productPage.chooseProduct(productName,expectedDesc,expectedPrice);


    }
    @Test(dataProvider = "TestingOrderingProduct",dataProviderClass = AllData.class)
    public void validateProductCheckOutSuccessfully( String productName, String expectedName, String expectedPrice,String expectedMessage) throws InterruptedException {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));

        ProductPage productPage = new ProductPage(driver);
        productPage.validateProductsAddToCart(productName, expectedName, expectedPrice);

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickCheckOutButton();
        checkOutPage.validateProductCheckOut(ConfigReader.readProperty("QA_firstName"),
                ConfigReader.readProperty("QA_lastName"),ConfigReader.readProperty("QA_postCode"),expectedMessage);







    }



}
