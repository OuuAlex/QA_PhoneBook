package com.ait.phonebook.tests;


import com.ait.phonebook.fw.models.Contact;
import com.ait.phonebook.fw.models.User;
import com.ait.phonebook.fw.utils.ContactData;
import com.ait.phonebook.fw.utils.DataProviders;
import com.ait.phonebook.fw.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class AddContactTests extends TestBase{
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
    }

    @Test
    public void addContactPositiveTest(Contact contact){
        app.getContact().clickOnAddLink();
        logger.error("Tests run whit data: " + contact.toString());

        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setSurname(ContactData.SURNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDesc(ContactData.DESCRIPTION));
        //click on Save button - .add_form__2rsm2 button - css
        app.getContact().clickOnSaveButton();
        //assert by text contact is added
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }



    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderPositiveTest(String name, String lastName, String phone,
                                                          String email, String address, String desc){
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setSurname(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));

        app.getContact().clickOnSaveButton();
    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderCSWPositiveTest(Contact contact){
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(contact);

        app.getContact().clickOnSaveButton();
    }

}
