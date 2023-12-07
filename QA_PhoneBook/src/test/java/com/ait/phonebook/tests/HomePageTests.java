package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHomePage().isHomeComponentPresent()){
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest(){
        //driver.findElement(By.xpath("//h1[text()='Home Component']"));
        app.getHomePage().isHomeComponentPresent();
        //System.out.println("Home Component is " + isElementPresent(By
        //        .xpath("//h1[text()='Home Component']")));
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
