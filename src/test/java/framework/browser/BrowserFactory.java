package framework.browser;

import framework.Log;
import framework.utils.ReadJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    private BrowserFactory(){}
    protected static WebDriver driver;

    private static String browser = ReadJson.getConfigData("browser").toString().toLowerCase();

    protected static void setDriver() {
        switch (browser) {
            case ("chrome"):
                driver = new ChromeDriver(WebDriverConfig.configChrome());
                break;
            case ("firefox"):
                driver = new FirefoxDriver(WebDriverConfig.configFirefox());
                break;
            default: driver = null;
                Log.error("The driver is incorrectly defined in the configuration");
            throw new RuntimeException("Incorrect BrowserName");
        }
    }
}
