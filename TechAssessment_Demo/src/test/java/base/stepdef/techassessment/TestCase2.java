package base.stepdef.techassessment;

import base.pageobjects.JupiterContactPage;
import base.pageobjects.JupiterHomePage;
import base.pageobjects.JupiterShopPage;
import base.testbase.TestBase;
import io.cucumber.java.en.Then;

public class TestCase2 {
    private final JupiterHomePage home;
    private final JupiterShopPage shop;
    private final JupiterContactPage contact;
    private final TestBase actions;

    public TestCase2(JupiterHomePage home, JupiterShopPage shop, JupiterContactPage contact, TestBase actions) {
        this.home = home;
        this.shop = shop;
        this.contact = contact;
        this.actions = actions;
    }

    @Then("run scenario testcase2 John")
    public void assessment_testcase2_user1() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Contact);
        actions.enter(contact.contactPage_txtbx_Forename, "John Doe");
        actions.enter(contact.contactPage_txtbx_Email, "johndoe@email.com");
        actions.enter(contact.contactPage_txtbx_Message, "Hello!");
        actions.click(contact.contactPage_btn_Submit);
        actions.implicitWait(15);
        actions.verifyVisibility(contact.contactPage_successmsg_Submit, true);
        /*Verify Success Message*/
        actions.verifyText(contact.contactPage_successmsg_Submit, "Thanks John Doe, we appreciate your feedback.");
    }

    @Then("run scenario testcase2 Mark")
    public void assessment_testcase2_user2() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Contact);
        actions.enter(contact.contactPage_txtbx_Forename, "Mark Doe");
        actions.enter(contact.contactPage_txtbx_Email, "markdoe@email.com");
        actions.enter(contact.contactPage_txtbx_Message, "Hello!");
        actions.click(contact.contactPage_btn_Submit);
        actions.implicitWait(15);
        actions.verifyVisibility(contact.contactPage_successmsg_Submit, true);
        /*Verify Success Message*/
        actions.verifyText(contact.contactPage_successmsg_Submit, "Thanks Mark Doe, we appreciate your feedback.");
    }

    @Then("run scenario testcase2 Leithold")
    public void assessment_testcase2_user3() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Contact);
        actions.enter(contact.contactPage_txtbx_Forename, "Leithold Doe");
        actions.enter(contact.contactPage_txtbx_Email, "leitholddoe@email.com");
        actions.enter(contact.contactPage_txtbx_Message, "Hello!");
        actions.click(contact.contactPage_btn_Submit);
        actions.implicitWait(15);
        actions.verifyVisibility(contact.contactPage_successmsg_Submit, true);
        /*Verify Success Message*/
        actions.verifyText(contact.contactPage_successmsg_Submit, "Thanks Leithold Doe, we appreciate your feedback.");
    }

    @Then("run scenario testcase2 Max")
    public void assessment_testcase2_user4() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Contact);
        actions.enter(contact.contactPage_txtbx_Forename, "Max Doe");
        actions.enter(contact.contactPage_txtbx_Email, "maxdoe@email.com");
        actions.enter(contact.contactPage_txtbx_Message, "Hello!");
        actions.click(contact.contactPage_btn_Submit);
        actions.implicitWait(15);
        actions.verifyVisibility(contact.contactPage_successmsg_Submit, true);
        /*Verify Success Message*/
        actions.verifyText(contact.contactPage_successmsg_Submit, "Thanks Max Doe, we appreciate your feedback.");
    }

    @Then("run scenario testcase2 September")
    public void assessment_testcase2_user5() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Contact);
        actions.enter(contact.contactPage_txtbx_Forename, "September Doe");
        actions.enter(contact.contactPage_txtbx_Email, "septemberdoe@email.com");
        actions.enter(contact.contactPage_txtbx_Message, "Hello!");
        actions.click(contact.contactPage_btn_Submit);
        actions.implicitWait(15);
        actions.verifyVisibility(contact.contactPage_successmsg_Submit, true);
        /*Verify Success Message*/
        actions.verifyText(contact.contactPage_successmsg_Submit, "Thanks September Doe, we appreciate your feedback.");
    }
}
