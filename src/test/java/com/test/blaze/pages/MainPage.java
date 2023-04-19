package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//div[@class='list-group']//a[3]" )
    WebElement lapTop;

    @FindBy(linkText = "Cart")
    WebElement cart;
    public void clickLaptop(){
        lapTop.click();
    }

    public void clickCart(){
        cart.click();
}

}
