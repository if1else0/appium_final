package appium1.testcases.login;

import appium1.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class LoginStatusCheck extends BasicTestCase{

    @Test
    public void testShouldLogin() throws Exception {
        pageManager.getPageCommon().goToMySettingsTab();
        pageManager.getPageMySettings().clickMyMsgItem();
        assertTrue(pageManager.getPageLogin().isLoginPage());
        pageManager.getPageLogin().clickBackImageButton();

        pageManager.getPageMySettings().clickMyBlogItem();
        assertTrue(pageManager.getPageLogin().isLoginPage());
        pageManager.getPageLogin().clickBackImageButton();

        pageManager.getPageMySettings().clickMyActivitiesItem();
        assertTrue(pageManager.getPageLogin().isLoginPage());
        pageManager.getPageLogin().clickBackImageButton();

        pageManager.getPageMySettings().clickMyTeamItem();
        assertTrue(pageManager.getPageLogin().isLoginPage());
        pageManager.getPageLogin().clickBackImageButton();
    }
}
