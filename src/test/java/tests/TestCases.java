package tests;

import demoQA.apiDemoQA.ApiUtils;
import demoQA.pages.BookStorePage;
import demoQA.pages.LoginPage;
import demoQA.pages.ProfilePage;
import framework.browser.BrowserUtil;
import framework.utils.JsonUtils;
import framework.utils.ReadJson;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.Log;

import java.util.List;

public class TestCases extends BaseTest {

    @Test
    public void checkUser() {
        String USER_NAME = ReadJson.getTestingData("userName").toString();
        String PASSWORD = ReadJson.getTestingData("password").toString();
        BookStorePage bookStorePage = new BookStorePage();
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();

        Log.startTestCase("Test1");
        ApiUtils.createAccount(USER_NAME, PASSWORD);
        BrowserUtil.openPage();
        Assert.assertTrue(bookStorePage.isOpen(), "BookStore page didn't open");
        BrowserUtil.scroll(400);
        bookStorePage.getLeftSideMenuForm().clickLoginButton();
        Assert.assertTrue(loginPage.isOpen(), "Login page didn't open");
        BrowserUtil.scroll(100);
        loginPage.setUserName(USER_NAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(profilePage.isOpen(), "Profile page didn't open");
        Assert.assertEquals(USER_NAME, profilePage.getUserNameValue(), "User name is incorrect");
        Log.endTestCase("Test1");
    }
    @Test
    public void bookStoreAPI() {
        BookStorePage bookStorePage = new BookStorePage();

        Log.startTestCase("Test2");
        BrowserUtil.openPage();
        Assert.assertTrue(bookStorePage.isOpen(), "BookStore page didn't open");
        List<String> apiBookTitles = JsonUtils.getBookTitleListByAPI(ApiUtils.getBooks());
        List<String> uiBookTitles = bookStorePage.getBookTitlesListByUI();
        Assert.assertEquals(uiBookTitles, apiBookTitles, "Book titles is not equal");
        Log.endTestCase("Test2");
    }
}
