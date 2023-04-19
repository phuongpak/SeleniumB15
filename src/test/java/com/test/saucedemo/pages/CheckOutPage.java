package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CheckOutPage {
    public CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#checkout")
    WebElement checkOutButton;

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(xpath = "//button[contains(text(),'Finish')]")
    WebElement finishButton;

    @FindBy(tagName = "h2")
    WebElement messageOrder;


    public void clickCheckOutButton(){
        checkOutButton.click();
    }
    public void validateProductCheckOut(String firstName, String lastName, String zipCode, String expectedMessage) throws InterruptedException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        continueButton.click();
        Thread.sleep(3000);
        finishButton.click();
        Assert.assertEquals(BrowserUtils.getText(messageOrder),expectedMessage );
    }




}
