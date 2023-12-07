package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests  extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
            //precondition: user should be logged out
            if (!app.getUser().isLoginLinkPresent()) {
                app.getUser().clickOnSingOutButton();
            }
            //click on Login link - a:nth-child(4) - css
        app.getUser().login();
        app.getContact().addContact();
    }

    @Test
    public void removeContactPositiveTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on contact card - .contact-item_card__2SOIM - css
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //assert contact is removed
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
