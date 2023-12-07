package org.ait.phonebook;


import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
        app.getUser().login();
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnSingOutButton();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User().setEmail("ouu@gmail.com").setPassword("Ouu123456$"));
        //click on Registration button - //button[text()='Registration'] - xpath
        app.getUser().clickOnRegistrationButton();
        //assert alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
