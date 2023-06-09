package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SauceLoginPage {
    public SauceLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#user-name")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(id ="login-button" )
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement message;



    public void loginPositive(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void loginNegative(String username, String password,String errorMessage){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(message), errorMessage );
    }




}
