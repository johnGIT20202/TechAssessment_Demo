package base.stepdef.techassessment;

import base.pageobjects.JupiterContactPage;
import base.pageobjects.JupiterHomePage;
import base.pageobjects.JupiterShopPage;
import base.testbase.TestBase;
import io.cucumber.java.en.Then;

public class TestCase1 {

    private final JupiterHomePage home;
    private final JupiterShopPage shop;
    private final JupiterContactPage contact;
    private final TestBase actions;

    public TestCase1(JupiterHomePage home, JupiterShopPage shop, JupiterContactPage contact, TestBase actions) {
        this.home = home;
        this.shop = shop;
        this.contact = contact;
        this.actions = actions;
    }

    @Then("run scenario testcase1")
    public void assessment_testcase1() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Contact);
        actions.click(contact.contactPage_btn_Submit);

        /*Header Error Message Validation*/
        actions.verifyVisibility(contact.contactPage_errmsg_Submit, true);
        actions.verifyText(contact.contactPage_errmsg_Submit, "We welcome your feedback - but we won't get it unless you complete the form correctly.");

        /*Forename Error Message Validation*/
        actions.verifyVisibility(contact.contactPage_errmsg_Forename, true);
        actions.verifyText(contact.contactPage_errmsg_Forename, "Forename is required");

        /*Email Error Message Validation*/
        actions.verifyVisibility(contact.contactPage_errmsg_Email, true);
        actions.verifyText(contact.contactPage_errmsg_Email, "Email is required");
        actions.enter(contact.contactPage_txtbx_Email, "test");
        actions.verifyVisibility(contact.contactPage_errmsg_Email2, true);
        actions.verifyText(contact.contactPage_errmsg_Email2, "Please enter a valid email");

        /*Message Error Message Validation*/
        actions.verifyVisibility(contact.contactPage_errmsg_Message, true);
        actions.verifyText(contact.contactPage_errmsg_Message, "Message is required");

        actions.enter(contact.contactPage_txtbx_Forename, "John Doe");
        actions.enter(contact.contactPage_txtbx_Email, "johndoe@email.com");
        actions.enter(contact.contactPage_txtbx_Message, "Hello!");
        actions.verifyVisibility(contact.contactPage_errmsg_Submit, false);
        actions.verifyVisibility(contact.contactPage_errmsg_Forename, false);
        actions.verifyVisibility(contact.contactPage_errmsg_Email, false);
        actions.verifyVisibility(contact.contactPage_errmsg_Email2, false);
        actions.verifyVisibility(contact.contactPage_errmsg_Message, false);
    }
}
