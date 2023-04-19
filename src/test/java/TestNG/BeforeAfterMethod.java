package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
    @BeforeMethod
    public void hello(){
        System.out.println("test1");
    }
    @Test
    public void hello2(){
        System.out.println("test2");
    }
    @Test
    public void hello3(){
        System.out.println("test3");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
}
