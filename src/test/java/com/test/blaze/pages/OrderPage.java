package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css="#country")
    WebElement country;

    @FindBy(xpath = "//label[@for='city']//following-sibling::input")
    WebElement city;


    @FindBy(css="#card")
    WebElement creditCard;

    @FindBy(xpath = "//input[@id='month']")
    WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purChase;
    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement purchaseConfirmation;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void clickOrderButton(){
        placeOrderButton.click();
    }


    public void validateOrderFunctionality
            (String name, String country, String city, String creditCard,String month,String year,String expectedPurchaseConfirmation) throws InterruptedException {
      this.name.sendKeys(name);
      Thread.sleep(1000);
      this.country.sendKeys(country);
        Thread.sleep(1000);
      this.city.sendKeys(city);
        Thread.sleep(1000);
      this.creditCard.sendKeys(creditCard);
        Thread.sleep(1000);
      this.month.sendKeys(month);
        Thread.sleep(1000);
      this.year.sendKeys(year);
        Thread.sleep(1000);
      purChase.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(purchaseConfirmation),expectedPurchaseConfirmation);
        Thread.sleep(1000);
        okButton.click();


    }






}

