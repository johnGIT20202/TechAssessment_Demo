package base.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private WebDriver driver = null;
    public String driverRepo = null;

    public void setDriver(String browserType) throws Exception {
        if(browserType.equalsIgnoreCase("Chrome")){
            if(driverRepo.equals("local")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/webdriver/chromedriver.exe");
            } else {
                driver = WebDriverManager.chromedriver().create();
            }
        } else if(browserType.equalsIgnoreCase("Edge")){
            if(driverRepo.equals("local")){
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/webdriver/msedgedriver.exe");
            } else {
                driver = WebDriverManager.edgedriver().create();
            }
        }
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
