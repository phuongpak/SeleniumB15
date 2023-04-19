package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ManagerBankPage {
public ManagerBankPage(WebDriver driver){
    PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//div[@class='center']//button[@ng-class='btnClass1']")
    WebElement addCustomerButton;


@FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
@FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
@FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
@FindBy(xpath = "//button[.='Add Customer']")
    WebElement submitAddButton;



@FindBy(xpath = "//button[@ng-click='openAccount()']")
WebElement openAccountButton;
@FindBy(css = "#userSelect")
WebElement customerOptions;
@FindBy(css="#currency")
WebElement currencyOptions;

@FindBy(xpath = "//button[contains(text(),'Process')]")
WebElement submitProcessButton;

@FindBy(xpath = "//button[contains(text(),'Customers')]")
WebElement customerButton;

@FindBy(xpath = "//input[@placeholder='Search Customer']")
WebElement searchBar;

@FindBy(xpath = "//tbody//tr[1]//td[@class='ng-binding']")
    List<WebElement> allInformation;

@FindBy(xpath = "//button[.='Delete']")
WebElement deleteButton;


public void validateAddCustomerFunctionality(WebDriver driver,String firstName, String lastName, String postCode, String message) throws InterruptedException {
    addCustomerButton.click();
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys(lastName);
    this.postCode.sendKeys(postCode);
    submitAddButton.click();
    Thread.sleep(3000);
    Alert alert = driver.switchTo().alert();
    Assert.assertTrue(alert.getText().trim().contains(message));
    alert.accept();

}

public void validateOpenAccountFunctionality(WebDriver driver, String fullName, String currencyValue,String message) throws InterruptedException {
    openAccountButton.click();
    Thread.sleep(3000);
    BrowserUtils.selectBy(customerOptions,fullName,"text");
    BrowserUtils.selectBy(currencyOptions,currencyValue,"value");
    Thread.sleep(3000);
    submitProcessButton.click();
    Alert alert = driver.switchTo().alert();
    Assert.assertTrue(alert.getText().contains(message));
    alert.accept();

}

public void validateCustomersInformationFunctionality(String name, String lastName,String postCode) throws InterruptedException {
    customerButton.click();
    searchBar.sendKeys(name);
    Thread.sleep(3000);
    List<String> expectedInformation = Arrays.asList(name,lastName,postCode);
    for(int i=0; i< allInformation.size(); i++){
        Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)) ,expectedInformation.get(i));
    }
    deleteButton.click();

}













}

