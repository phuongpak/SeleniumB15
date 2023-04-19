package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {


    @Test
    public void validateSuccessfulLogin() {
        WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();//aHMET WEBSITE NOT WORK SO HE HAS THIS CODES
//            options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);//
        loginPage.login("EM01", "sentrifugo");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("welcome"));
        //THE REASON I DID NOT VALIDATE TITLE CUZ BF AND AFTER LOGIN TITLE IS SAME
        //IT MEANS IT IS NOT RELIABLE
    }

        @Test
        public void validateNegativeLogin1(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("http://demo.sentrifugo.com/index.php/");

            LoginPage loginPage = new LoginPage(driver);//
            loginPage.login("ahmet","sentrifugo");
            Assert.assertEquals(loginPage.validateErrorMessage(),"The username or password you entered is incorrect.");
            Assert.assertEquals(loginPage.validateColorOfErrorMessage(),"rgba(255, 0, 0, 1)");



        }












    }

