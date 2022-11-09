package base.pageobjects;

public class JupiterShopPage {

    public final String shopPage_link_Cart = "//a[@href='#/cart']";
    public final String shopPage_item_btn_Buy = "//h4[text()='item']/following-sibling::p/a";
    public final String shopPage_item_lbl_Price = "//h4[text()='item']/following-sibling::p/span";
    public final String shopPage_Cart_item_lbl_Price = "//td[text()='item']/following-sibling::td[1]";
    public final String shopPage_Cart_item_lbl_Subtotal = "//td[text()='item']/following-sibling::td[3]";
    public final String shopPage_Cart_item_lbl_Total = "//strong[contains(text(),'Total:')]";
}
