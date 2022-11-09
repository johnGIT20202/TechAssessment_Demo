package base.testbase;

import base.utility.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public String baseUrl = null;
    public String browserType = null;
    public String scenario = null;
    public HashMap<String, String> items = new HashMap<String, String>();

    private WebDriverWait wait = null;

    private final BrowserManager browser;

    public TestBase(BrowserManager browser) {
        this.browser = browser;
    }

    public void navigate(String browserType) throws Exception{
        try{
            browser.setDriver(browserType);
            browser.getDriver().get(this.baseUrl);
            System.out.println("Scenario: "+ scenario +" Successfully navigate to: "+this.baseUrl + " " +getCurrentTime());
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
    }

    public void click(String obj) throws Exception{
        try{
            wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj)));
            new Actions(browser.getDriver()).moveToElement(element).build().perform();
            element.click();
            System.out.println("Scenario: "+ scenario +" :Successfully clicked the element" + " " +getCurrentTime());
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
    }

    public void enter(String obj, String text) throws Exception{
        try{
            wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj)));
            new Actions(browser.getDriver()).moveToElement(element).build().perform();
            element.click();
            element.clear();
            element.sendKeys(text);
            System.out.println("Scenario: "+ scenario +" :Successfully enter: " +text+ " " +getCurrentTime());
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
    }

    public void verifyVisibility(String obj, boolean isVisible) throws Exception{
        try{
            wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
            if(browser.getDriver().findElements(By.xpath(obj)).size()!=0){
                if(isVisible){
                    System.out.println("Scenario: "+ scenario +" :Element is visible as expected" + " " +getCurrentTime());
                } else {
                    System.out.println("Scenario: "+ scenario +" :Element should be visible" + " " +getCurrentTime());
                    Assert.fail();
                }
            } else {
                if(isVisible){
                    System.out.println("Scenario: "+ scenario +" :Element should not be visible" + " " +getCurrentTime());
                    Assert.fail();
                } else {
                    System.out.println("Scenario: "+ scenario +" :Element is not visible as expected" + " " +getCurrentTime());
                }
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
    }

    public void verifyText(String obj, String text) throws Exception{
        try{
            wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj)));
            new Actions(browser.getDriver()).moveToElement(element).build().perform();
            if (element.getText().contains(text)) {
                System.out.println("Scenario: "+ scenario +" :Element is contains text as expected" + " " +getCurrentTime());
            } else {
                System.out.println("Scenario: "+ scenario +" :Element text is not the expected" + " " +getCurrentTime());
                Assert.fail();
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
    }

    public String getCurrentTime() throws Exception{
        String time = null;
        DateFormat dformat = new SimpleDateFormat("MM-dd-HH-mm-ss");
        Date date = new Date();
        time = dformat.format(date);
        return time;
    }

    public void hardWait(int time) throws Exception{
        Thread.sleep(time);
    }

    public void implicitWait(int time) throws Exception{
        browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public String getText(String obj) throws Exception{
        String text = null;
        try{
            wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj)));
            text = element.getText();
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
        return text;
    }

    public boolean getVisibility(String obj) throws Exception{
        boolean isVisible = false;
        try{
            wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
            if(browser.getDriver().findElements(By.xpath(obj)).size()!=0){
                isVisible = true;
            }
        }catch (Exception e){
            System.out.println("Scenario: "+ scenario + " " + e.toString() + " "
                    + Thread.currentThread().getStackTrace()[1].getMethodName() + " " +getCurrentTime());
            Assert.fail();
        }
        return isVisible;
    }

}
