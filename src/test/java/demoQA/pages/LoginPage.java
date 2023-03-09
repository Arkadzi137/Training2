package demoQA.pages;

import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import framework.form.BaseForm;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {

    private static final Label userNameLabel = new Label(By.id("userName-label"), "User name Label");
    private final Input userNameTextBox = new Input(By.id("userName"), "User name TextBox");
    private final Input passwordTextBox = new Input(By.id("password"), "Password TextBox");
    private final Button loginButton = new Button(By.id("login"), "Login Button");

    public LoginPage() {
        super(userNameLabel, "Login Form");
    }

    public void setUserName(String userName) {
        userNameTextBox.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.waitUntilElementToBeClickable();
        loginButton.click();
    }
}
