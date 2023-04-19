package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

   @FindBy(css = ".inventory_item_name")
   List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement nameOfProduct;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartLink;






    public void chooseProduct(String productName,String expectedDesc, String expectedPrice){

        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).contains(productName)){
                product.click();
                break;
            }
        }

        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDesc));
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);



    }
    /*
    go to website, click on product, validate name, price, add to cart, check out,..
     */

    public void validateProductsAddToCart(String name,String expectedName, String expectedPrice) throws InterruptedException {
        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).contains(name)){
                product.click();
                break;
            }
        }
          Assert.assertEquals(BrowserUtils.getText(nameOfProduct),expectedName);
          Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);

          addToCartButton.click();
          Thread.sleep(3000);

          cartLink.click();











    }




}
