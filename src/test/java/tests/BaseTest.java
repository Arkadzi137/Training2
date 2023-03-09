package tests;

import framework.browser.BrowserUtil;
import framework.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest {

    @BeforeMethod
    public void setup() {
        Log.info("Setup");
        BrowserUtil.setBrowserWindowMaximize();
    }

    @AfterMethod
    public void tearDown() {
        Log.info("Setup");
        BrowserUtil.killDriver();
    }
}

