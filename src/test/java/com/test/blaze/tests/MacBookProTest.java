package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LapTopPage;
import com.test.blaze.pages.MacBookPage;
import com.test.blaze.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MacBookProTest extends TestBaseBlaze{
    /*
   1-Navigate to the website "https://www.demoblaze.com/#"
   2-Click the Laptops from homepage(firstPage)
   3-Click MacBook Pro from the list with Loop(LaptopPage)
   4-Validate the header="MacBook Pro"(MacBook Pro Page)
   5-Validate the price=$1100 *includes tax(MacBook Pro Page)
   6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multi-touchstrip display that sits above the MacBook Pro's keyboard."
   7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button

   6-Click Cart Button top(WebElement can be in MainPage)
7-Validate the Name of Product and Price(no need test class for it just method)
8-Click Place Order and provide all the information(ORDER PAGE)
9-Validate the Thank you message and click OK
10-Validate the url is "https://www.demoblaze.com/index.html"
    */

//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//
//    }

    @Parameters({"laptopBrand","laptopPrice","message","description"})
    @Test
    public void validateMacBookProInFo(String laptopBrand, String laptopPrice, String message, String description ) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptop();

        LapTopPage laptopPage =new LapTopPage(driver);
        laptopPage.clickMacBookPro(laptopBrand);

        MacBookPage macBookPage = new MacBookPage(driver);
        macBookPage.validateMacBookInFormation(laptopBrand,laptopPrice,description);

        macBookPage.clickAddToCartButton(driver,message);

//        CartPage cartPage = new CartPage(driver);
//        cartPage.validateProductInfo("MacBook Pro","1100");

    }




//    @AfterMethod
//    public void tearDownAfterValidating(){
//        driver.quit();
//
//    }

}
