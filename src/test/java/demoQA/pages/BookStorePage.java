package demoQA.pages;

import demoQA.pages.forms.LeftSideMenuForm;
import framework.elements.Label;
import framework.form.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

public class BookStorePage extends BaseForm {

    private static final Label header = new Label(By.xpath("//div[contains(@class,'main-header')]"), "Header");
    private final Label bookTitles = new Label(By.xpath("//div[contains(@class, 'action-buttons')]//a"), "Book titles");
    private final LeftSideMenuForm leftSideMenuForm = new LeftSideMenuForm();

    public BookStorePage() {
        super(header, "BookStorePage");
    }

    public LeftSideMenuForm getLeftSideMenuForm() {
        return leftSideMenuForm;
    }

    public List<String> getBookTitlesListByUI() {
        return bookTitles.getTexts();
    }
}
