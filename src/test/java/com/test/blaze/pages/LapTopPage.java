package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LapTopPage {
    public LapTopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".card-title")
    List<WebElement> macBookPro;


    public void clickMacBookPro(String brand) throws InterruptedException {
        for(int i=0; i< macBookPro.size();i++){
            if(macBookPro.get(i).getText().contains(brand)){
                Thread.sleep(3000);
                macBookPro.get(i).click();
            }
        }
    }
}
