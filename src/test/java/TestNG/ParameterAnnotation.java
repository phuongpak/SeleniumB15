package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("firstName")

    @Test
    public void test(String name){

        System.out.println(name);
    }
    @Parameters({"country", "city","zipCode"})
    @Test
    public void test2(String country, String city, String zipCode){
        System.out.println(city);
        System.out.println(country);
        System.out.println(zipCode);
    }
}
