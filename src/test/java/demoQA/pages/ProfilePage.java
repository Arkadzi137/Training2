package demoQA.pages;

import framework.elements.Label;
import framework.form.BaseForm;
import org.openqa.selenium.By;

public class ProfilePage extends BaseForm {

    private static final Label userNameValueLabel = new Label(By.xpath("//label[contains(@id, 'userName-value')]"), "User name value Label");

    public ProfilePage() {
        super(userNameValueLabel, "Profile Page");
    }

    public String getUserNameValue() {
        return userNameValueLabel.getText();
    }
}
