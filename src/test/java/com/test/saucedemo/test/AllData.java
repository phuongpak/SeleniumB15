package com.test.saucedemo.test;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name="negativeLogin")
    public Object[][] getUserInfo(){
        return new Object[][]{

                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"sdsd","asf","Epic sadface: Username and password do not match any user in this service"}
        };
    }


    @DataProvider(name = "TestingProductLinks")
    public Object[][] getProductData() {
        return new Object[][]{
                {"Sauce Labs Backpack","Sly Pack","$29.99"},
                {"Sauce Labs Bike Light","riding your bike ","$9.99"},
                {"Sauce Labs Bolt T-Shirt","bolt T-shirt","$15.99"},
                {"Sauce Labs Fleece Jacket","fleece jacket","$49.99"},
                {"Sauce Labs Onesie","infant onesie","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Labs t-shirt","$15.99"}
        };
    }

    @DataProvider(name="TestingOrderingProduct")
    public Object[][] getProductInfo(){
        return new Object[][]{
                {"Sauce Labs Backpack","Sauce Labs Backpack","$29.99","Thank you for your order!"},
                {"Sauce Labs Bike Light","Sauce Labs Bike Light","$9.99","Thank you for your order!"},
                {"Sauce Labs Bolt T-Shirt","Sauce Labs Bolt T-Shirt","$15.99","Thank you for your order!"},
                {"Sauce Labs Fleece Jacket","Sauce Labs Fleece Jacket","$49.99","Thank you for your order!"},
                {"Sauce Labs Onesie","Sauce Labs Onesie","$7.99","Thank you for your order!"},
                {"Test.allTheThings() T-Shirt (Red)","Test.allTheThings() T-Shirt (Red)","$15.99","Thank you for your order!"}
        };


    }
}
