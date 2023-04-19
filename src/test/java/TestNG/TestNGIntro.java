package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {


//@Test: @ means annotation, it acts like main method

    @Test(priority=2)//test annotation--->
    public void test1(){
        System.out.println("I am test 1");
    }

    @Test(priority=1,invocationCount =20)
    public void test2(){
     System.out.println("I am test2");
    }

    @Test(priority=3)
    public void test3(){
        System.out.println("I am test3");
    }


}
