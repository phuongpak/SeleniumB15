package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookPage {
    public MacBookPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2")
    WebElement header;

    @FindBy(xpath = "//h3")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']//p")
    WebElement productDescription;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;

    public void validateMacBookInFormation(String laptopHeader, String lappPrice,String laptopDesc ){
        Assert.assertEquals(BrowserUtils.getText(header),laptopHeader);
        Assert.assertEquals(BrowserUtils.getText(price), lappPrice);
        Assert.assertTrue(BrowserUtils.getText(productDescription).contains(laptopDesc));


    }
    public void clickAddToCartButton(WebDriver driver,String expectedAlert) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlert);
        alert.accept();
    }



}
