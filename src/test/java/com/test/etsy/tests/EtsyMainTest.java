package com.test.etsy.tests;

import com.test.blaze.pages.MainPage;
import com.test.etsy.pages.EtsyMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends TestBaseEtsy{
    /*
1-Navigate to the website from ConfigReader --> provide value in configuration.properties
2-Search for "iphone 13 case"
3-Make sure all of the headers contains iphone or 13 or Case
4-Activate after method driver.quit//open the command //

     */


//name from line parameter 20, (22), and xml file have to match

    @Parameters({"searchWord","brand","model","phoneCase"})
    @Test
    public void validateSearchFunctionality(String searchWord, String brand, String model, String phoneCase){
        EtsyMainPage etsyMainPage = new EtsyMainPage(driver);
        etsyMainPage.searchData(searchWord);
        etsyMainPage.validateHeader(brand,model,phoneCase);
    }





}
