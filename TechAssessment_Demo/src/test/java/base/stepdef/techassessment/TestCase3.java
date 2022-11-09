package base.stepdef.techassessment;

import base.pageobjects.JupiterContactPage;
import base.pageobjects.JupiterHomePage;
import base.pageobjects.JupiterShopPage;
import base.stepdef.template.TestCase3Template;
import base.testbase.TestBase;
import io.cucumber.java.en.Then;

public class TestCase3 {

    private final JupiterHomePage home;
    private final JupiterShopPage shop;
    private final JupiterContactPage contact;
    private final TestBase actions;
    private final TestCase3Template test3template;

    public TestCase3(JupiterHomePage home, JupiterShopPage shop, JupiterContactPage contact, TestBase actions, TestCase3Template test3template) {
        this.home = home;
        this.shop = shop;
        this.contact = contact;
        this.actions = actions;
        this.test3template = test3template;
    }

    @Then("run scenario testcase3")
    public void assessment_testcase3() throws Exception{
        actions.navigate(actions.browserType);
        actions.click(home.homePage_menu_Shop);

        /*Buy Items*/
        test3template.clickItemBuyAndGetPrice("Stuffed Frog", "2");
        test3template.clickItemBuyAndGetPrice("Fluffy Bunny", "5");
        test3template.clickItemBuyAndGetPrice("Valentine Bear", "3");

        /*Go to Cart Page*/
        actions.click(shop.shopPage_link_Cart);

        /*Verify Item Price in Cart*/
        test3template.CartVerifyItemPrice();

        /*Verify Item Subtotal*/
        test3template.CartCalculateAndVerifyItemSubTotal();

        /*Verify Item Total*/
        test3template.CartCalculateAndVerifyTotal();
    }
}

