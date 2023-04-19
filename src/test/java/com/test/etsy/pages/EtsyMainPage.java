package com.test.etsy.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@name='search_query']")
    WebElement searchBar;

//    @FindBy(xpath = "//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
//    WebElement searchButton;//we use Keys.ENTER

    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void searchData(String search){
        searchBar.sendKeys(search, Keys.ENTER);


    }
    public void validateHeader(String phoneName, String model, String phoneCase){


        for(WebElement header: allHeaders) {
            String word=BrowserUtils.getText(header).toLowerCase();

            Assert.assertTrue(word.contains(phoneName) || word.contains(model) || word.contains(phoneCase) );




            }
        }
    }





