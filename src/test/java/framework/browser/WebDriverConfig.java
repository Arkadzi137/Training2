package framework.browser;

import framework.utils.ReadJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

abstract public class WebDriverConfig {
    private final  static String location = ReadJson.getConfigData("locale").toString().toLowerCase();
    private final  static String language = ReadJson.getConfigData("language").toString().toLowerCase();
    private final  static String browser = ReadJson.getConfigData("browser").toString().toLowerCase();

    private static boolean incognitoIsTrue(){
        return (boolean) ReadJson.getConfigData("incognito");
    }

    protected static ChromeOptions configChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (incognitoIsTrue()) {
            options.addArguments(configIncognito());
        }
        options.addArguments(localeAndLanguage());
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    protected static FirefoxOptions configFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (incognitoIsTrue()) {
            options.addArguments(configIncognito());
        }
        options.addArguments(localeAndLanguage());
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    private static String localeAndLanguage() {
        return "--lang=" + language.toLowerCase() + "-" + location.toUpperCase();
    }

    private static String configIncognito() {
        String incognito;
        switch (browser) {
            case ("chrome"):
                incognito = "--incognito";
                break;
            case ("firefox"):
                incognito = "-private";
                break;
            default:
                incognito = null;
        }
        return incognito;
    }
}
