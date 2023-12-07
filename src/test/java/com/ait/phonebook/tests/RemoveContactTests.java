package com.ait.phonebook.tests;

import com.ait.phonebook.fw.models.Contact;
import com.ait.phonebook.fw.models.User;
import com.ait.phonebook.fw.utils.ContactData;
import com.ait.phonebook.fw.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests  extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setSurname(ContactData.SURNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDesc(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
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
