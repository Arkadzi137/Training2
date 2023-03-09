package framework.browser;

import framework.utils.ReadJson;
import framework.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserUtil {

    public static WebDriver getDriver() {
        if (BrowserFactory.driver == null) {
            BrowserFactory.setDriver();
        }
        return BrowserFactory.driver;
    }

    public static void killDriver() {
        BrowserUtil.getDriver().quit();
        BrowserFactory.driver = null;
    }

    public static void setBrowserWindowMaximize(){
        Log.info("Maximize window of browser");
        getDriver().manage().window().maximize();
    }

    public static void openPage(){
        Log.info("open page: "+ ReadJson.getConfigData("url").toString().toLowerCase());
        getDriver().get(ReadJson.getConfigData("url").toString().toLowerCase());
    }

    public static void scroll(int i){
        JavascriptExecutor jse = (JavascriptExecutor)(getDriver());
        Log.info("scroll");
        jse.executeScript("window.scrollBy(0,"+i+")", "");
    }
}
