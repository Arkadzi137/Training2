package framework.elements;

import framework.Wait;
import framework.browser.BrowserUtil;
import framework.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseElement {
    protected By locator;
    protected String name;

    public BaseElement(By locator,String name){
        this.locator = locator;
        this.name = name;
    }
    protected List<WebElement> findElements(){
        return BrowserUtil.getDriver().findElements(locator);
    }

    public void click(){
        Log.info("click "+name);
        BrowserUtil.getDriver().findElement(locator).click();
    }

    public String getText(){
        Log.info("get Text from "+name);
        return BrowserUtil.getDriver().findElement(locator).getText();
    }

    public List<String> getTexts(){
        Log.info("get Text from "+name);
        List<String> stringList = new ArrayList<>();
        List<WebElement> list = BrowserUtil.getDriver().findElements(locator);
        for (int i = 0; i < list.size(); i++) {
            stringList.add(list.get(i).getText());
        }
        return stringList;
    }

    public boolean isVisible(){
        Log.info("Check that " + name + " is visible");
        List <WebElement> list = BrowserUtil.getDriver().findElements(locator);
        if (list.isEmpty()) {
            System.out.println(list.isEmpty());
            return false;}
        return true;
    }

    private WebElement getWebElement(){
        return BrowserUtil.getDriver().findElement(locator);
    }

    public void waitUntilElementIsAppear() {
        Wait.waitUntilWebElementIsAppear(locator);
    }

    public void waitUntilElementToBeClickable() {
        Wait.waitUntilWebElementToBeClickable(this.getWebElement());
    }
}
