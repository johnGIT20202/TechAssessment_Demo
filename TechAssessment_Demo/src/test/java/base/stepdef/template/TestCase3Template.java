package base.stepdef.template;

import base.pageobjects.JupiterShopPage;
import base.testbase.TestBase;
import org.testng.Assert;

public class TestCase3Template {

    private final TestBase actions;
    private final JupiterShopPage shop;

    public TestCase3Template(TestBase actions, JupiterShopPage shop) {
        this.actions = actions;
        this.shop = shop;
    }

    public void getItemPrice(String item)throws Exception{
        try{
            String[] parts = shop.shopPage_item_lbl_Price.split("item");
            String newObj = parts[0] + item + parts[1];
            String itemPrice = actions.getText(newObj);
            actions.items.put(item + " Price", itemPrice);
            System.out.println("Scenario: "+ actions.scenario +" :Price for item: "+item+ " is " +itemPrice + " " +actions.getCurrentTime());
        }catch (Exception e){
            System.out.println("Scenario: "+ actions.scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +actions.getCurrentTime());
            Assert.fail();
        }
    }

    public void clickItemBuyAndGetPrice(String item, String count)throws Exception{
        try{
            String[] parts = shop.shopPage_item_btn_Buy.split("item");
            String newObj = parts[0] + item + parts[1];
            actions.items.put(item + " BuyCount", count);
            System.out.println("Scenario: "+ actions.scenario +" :Buy count for item: "+item+ " is " +count + " " +actions.getCurrentTime());
            for(int x=1; x <= Integer.parseInt(count); x++){
                actions.click(newObj);
                actions.implicitWait(2);
                if(x==Integer.parseInt(count)){
                    this.getItemPrice(item);
                }
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ actions.scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +actions.getCurrentTime());
            Assert.fail();
        }
    }

    public void CartVerifyItemPrice()throws Exception{
        System.out.println("Verifying Cart Item Price");
        try{
            String itemObj = "(//tr[@class='cart-item ng-scope']/td[1])";
            String cartPriceObj = "(//tr[@class='cart-item ng-scope']/td[2])";

            int x = 1;
            while(actions.getVisibility(itemObj + "["+x+"]")){
                System.out.println("Verifying for item no."+x);
                String itemName = actions.getText(itemObj + "["+x+"]");
                String cartPrice = actions.getText(cartPriceObj + "["+x+"]");
                if(actions.items.get(itemName + " Price") != null){
                    if(cartPrice.equals(actions.items.get(itemName + " Price"))){
                        System.out.println("Scenario: "+ actions.scenario +" :Cart Item price is the expected:"
                                + itemName + ":" + cartPrice
                                + " " +actions.getCurrentTime());
                    } else {
                        System.out.println("Scenario: "+ actions.scenario +" :Cart Item price for "+itemName+" is not the expected:"
                                + "\nActual: "+ cartPrice
                                + "\nExpected: "+ actions.items.get(itemName + " Price")
                                + " " +actions.getCurrentTime());
                        Assert.fail();
                    }
                }
                x++;
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ actions.scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +actions.getCurrentTime());
            Assert.fail();
        }
    }

    public void CartCalculateItemSubTotal(String item)throws Exception{
        try{
            int subtotal;
            int price = Integer.parseInt(actions.items.get(item + " Price").substring(1));
            int count = Integer.parseInt(actions.items.get(item + " BuyCount"));
            subtotal = count * price;
            actions.items.put(item + " SubTotal", Integer.toString(subtotal));
        }catch (Exception e){
            System.out.println("Scenario: "+ actions.scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +actions.getCurrentTime());
            Assert.fail();
        }
    }

    public void CartCalculateAndVerifyItemSubTotal()throws Exception{
        System.out.println("Verifying Cart Item SubTotal Price");
        try{
            String itemObj = "(//tr[@class='cart-item ng-scope']/td[1])";
            String cartSubTotalObj = "(//tr[@class='cart-item ng-scope']/td[4])";
            double subtotal = 0;
            double price = 0;
            double count = 0;

            int x = 1;
            while(actions.getVisibility(itemObj + "["+x+"]")){
                System.out.println("Verifying for item no."+x);
                String itemName = actions.getText(itemObj + "["+x+"]");
                String cartSubTotal = actions.getText(cartSubTotalObj + "["+x+"]");

                if(actions.items.get(itemName + " Price") != null &&
                        actions.items.get(itemName + " BuyCount") != null){
                    price = Double.parseDouble(actions.items.get(itemName + " Price").substring(1));
                    count = Double.parseDouble(actions.items.get(itemName + " BuyCount"));
                    subtotal = count * price;
                    actions.items.put(itemName + " SubTotal", "$" + Double.toString(subtotal));
                    if(cartSubTotal.equals(actions.items.get(itemName + " SubTotal"))){
                        System.out.println("Scenario: "+ actions.scenario +" :Cart Item subtotal price is the expected:"
                                + itemName + ":" +cartSubTotal
                                + " " +actions.getCurrentTime());
                    } else {
                        System.out.println("Scenario: "+ actions.scenario +" :Cart Item subtotal price is not the expected:"
                                + "\nActual: "+ cartSubTotal
                                + "\nExpected: "+ actions.items.get(itemName + " SubTotal")
                                + " " +actions.getCurrentTime());
                        Assert.fail();
                    }
                }
                x++;
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ actions.scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +actions.getCurrentTime());
            Assert.fail();
        }
    }

    public void CartCalculateAndVerifyTotal()throws Exception{
        System.out.println("Verifying Cart Item Total Price");
        try{
            String itemObj = "(//tr[@class='cart-item ng-scope']/td[1])";
            String cartTotal = actions.getText(shop.shopPage_Cart_item_lbl_Total);
            double total = 0;

            int x = 1;
            while(actions.getVisibility(itemObj + "["+x+"]")){
                System.out.println("Adding in total for item no."+x);
                String itemName = actions.getText(itemObj + "["+x+"]");
                if(actions.items.get(itemName + " SubTotal") != null){
                    total += Double.parseDouble(actions.items.get(itemName + " SubTotal").substring(1));
                    actions.items.put("Total", "Total: " + Double.toString(total));
                }
                x++;
            }

            if(cartTotal.equals(actions.items.get("Total"))){
                System.out.println("Scenario: "+ actions.scenario +" :Cart Item price total is the expected:" + cartTotal + " " +actions.getCurrentTime());
            } else {
                System.out.println("Scenario: "+ actions.scenario +" :Cart Item price total is not the expected:"
                        + "\nActual: "+ cartTotal
                        + "\nExpected: "+ actions.items.get("Total")
                        + " " +actions.getCurrentTime());
                Assert.fail();
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ actions.scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +actions.getCurrentTime());
            Assert.fail();
        }
    }

}
