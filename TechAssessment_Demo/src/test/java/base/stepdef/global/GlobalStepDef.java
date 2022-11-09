package base.stepdef.global;

import base.testbase.TestBase;
import base.utility.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.FileInputStream;
import java.util.Properties;

public class GlobalStepDef {

    private Properties config = null;
    private final TestBase actions;
    private final BrowserManager browser;

    public GlobalStepDef(TestBase actions, BrowserManager browser) {
        this.actions = actions;
        this.browser = browser;
    }

    @Before
    public void initialize(Scenario scenario) throws Exception{
        config = new Properties();

        FileInputStream getEnv = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Environment.properties");
        config.load(getEnv);

        browser.driverRepo = config.getProperty("DRIVER_REPO");
        actions.scenario = scenario.getName();
    }

    @Given("user navigate to {string}")
    public void getUrl(String url) throws Exception{
        actions.baseUrl = url;
    }

    @When("browser is {string}")
    public void getBrowser(String browser) throws Exception{
        actions.browserType = browser;
    }

    @After
    public void closeBrowser() throws Exception{
        browser.closeDriver();
    }

}
