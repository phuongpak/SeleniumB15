package com.test.practicebank.TestBankPractice;

import com.test.practicebank.pagesPractice.LoginBankPageForPractice;
import com.test.practicebank.pagesPractice.ManagerBankPageForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTestForPractice {
    @Test
    public void login(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        LoginBankPageForPractice loginBankForPractice = new LoginBankPageForPractice(driver);
        loginBankForPractice.clickManagerLoginButton();

        ManagerBankPageForPractice managerBankForPractice= new ManagerBankPageForPractice(driver);
        managerBankForPractice.validateAddCustomerFunctionality
                (driver,"ame","lia","60653","Customer added successfully with customer id :6");
    }
}
