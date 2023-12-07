package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
        //click on Login link - a:nth-child(4) - css
        app.getUser().clickOnLoginLink();
    }
    @Test
    public void loginPositiveTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("ouu@gmail.com")
                .setPassword("Ouu123456$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Out button present
        Assert.assertTrue(app.getUser().isSingOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().fillLoginRegistrationForm(new User().setPassword("Ouu123456$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Out button present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

