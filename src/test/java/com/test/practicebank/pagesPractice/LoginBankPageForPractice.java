package com.test.practicebank.pagesPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBankPageForPractice {
    /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE account successuflly created contains and click OK
10-Click Customers Button
11-Search your name on the searchBar
12-Validate your firstname,lastName,PostCode and click delete
13-driver.quit
14-Proud of yourself
 */
    public LoginBankPageForPractice(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement bankManagerLoginButton;

    public void clickManagerLoginButton(){
        bankManagerLoginButton.click();
    }







}
