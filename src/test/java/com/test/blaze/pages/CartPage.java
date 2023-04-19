package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(tagName = "td")
    List<WebElement> allProductInfo;



    public void validateProductInfo(String title, String price){
        List<String> expectedProductInfo = Arrays.asList("",title, price,"");//make it same size
        for(int i=1; i< allProductInfo.size()-1; i++){
            Assert.assertEquals(BrowserUtils.getText(allProductInfo.get(i)), expectedProductInfo.get(i));
        }


    }




}
