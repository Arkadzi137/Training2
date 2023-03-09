package framework.elements;

import framework.browser.BrowserUtil;
import framework.Log;
import org.openqa.selenium.By;

public class Input extends BaseElement {
    public Input(By locator, String name) {
        super(locator, name);
        this.locator = locator;
    }

    public void sendKeys(String str){
        Log.info("sent Text: "+str+" to "+name);
        BrowserUtil.getDriver().findElement(locator).sendKeys(str);
    }
}
