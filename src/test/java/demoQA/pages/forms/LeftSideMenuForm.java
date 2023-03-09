package demoQA.pages.forms;

import framework.elements.Button;
import framework.elements.Label;
import framework.form.BaseForm;
import org.openqa.selenium.By;

public class LeftSideMenuForm extends BaseForm {
    private final String leftMenuButtons = "//span[contains(text(),'%s')]//parent::li";
    private final Button loginButton = new Button(By.xpath(String.format(leftMenuButtons, "Login")), "Login Button");
    private static final Label leftSideMenu = new Label(By.xpath("//div[contains(@class,'left-pannel')]"), "Left side menu");

    public LeftSideMenuForm() {
        super(leftSideMenu, "LeftSideMenuForm");
    }

    public void clickLoginButton() {
        loginButton.waitUntilElementToBeClickable();
        loginButton.click();
    }
}
