package com.test.practicebank.pagesPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class ManagerBankPageForPractice {
    public ManagerBankPageForPractice(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//label[.='Post Code :']//following-sibling::input")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomer;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;
    @FindBy(name="userSelect")
    WebElement customersOption;
    @FindBy(css="#currency")
    WebElement currencyOptions;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButtonSubmit;
    public void validateAddCustomerFunctionality
            (WebDriver driver,String firstName, String lastName, String postCode,String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomer.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim() ,expectedMessage);
        alert.accept();

    }

    public void validateOpenAccountFunctionality(WebDriver driver, String fullName,String currencyValue,String expectedMessage){
        openAccountButton.click();
        BrowserUtils.selectBy(customersOption,fullName,"text");
        BrowserUtils.selectBy(currencyOptions,currencyValue,"value");
        processButtonSubmit.click();
        Alert alert =driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));

    }









}
