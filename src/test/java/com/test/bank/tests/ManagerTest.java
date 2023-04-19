package com.test.bank.tests;

import com.test.bank.pages.LoginBankPage;
import com.test.bank.pages.ManagerBankPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class ManagerTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("QA_url"));
    }

    @Test
    public void validateBankFunctionalityForManager() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        LoginBankPage loginBankPage = new LoginBankPage(driver);
        loginBankPage.clickManagerButton();

        ManagerBankPage managerBankPage = new ManagerBankPage(driver);
        managerBankPage.validateAddCustomerFunctionality(driver,ConfigReader.readProperty("QA_firstName"),ConfigReader.readProperty("QA_lastName"),ConfigReader.readProperty("QA_postCode"),"Customer added successfully");

        managerBankPage.validateOpenAccountFunctionality(driver,"phuong pak","Dollar","Account created successfully");

        managerBankPage.validateCustomersInformationFunctionality("phuong","pak","60446");


    }
@AfterMethod
    public void tearDown(){
        driver.quit();
}

}
