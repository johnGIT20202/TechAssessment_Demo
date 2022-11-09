package base.pageobjects;

public class JupiterContactPage {

    public String contactPage_txtbx_Forename = "//input[@id='forename']";
    public String contactPage_txtbx_Email = "//input[@id='email']";
    public String contactPage_txtbx_Message = "//textarea[@id='message']";
    public String contactPage_btn_Submit = "//a[text()='Submit']";
    public String contactPage_errmsg_Submit = "//div[@class='alert alert-error ng-scope']";
    public String contactPage_errmsg_Forename = "//span[@id='forename-err']";
    public String contactPage_errmsg_Email = "//span[@id='email-err' and text()='Email is required']";
    public String contactPage_errmsg_Email2 = "//span[@id='email-err' and text()='Please enter a valid email']";
    public String contactPage_errmsg_Message = "//span[@id='message-err']";
    public String contactPage_successmsg_Submit = "//div[@class='alert alert-success']";

}
