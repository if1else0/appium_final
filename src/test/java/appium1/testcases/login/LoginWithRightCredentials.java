package appium1.testcases.login;

import appium1.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginWithRightCredentials extends BasicTestCase{

    @Test
    public void testSuccessFullyLogin() throws Exception {
        pageManager.getPageCommon().goToMySettingsTab();
        pageManager.getPageMySettings().clickLoginIcon();
        pageManager.getPageLogin().login("735723619@qq.com","12345678");
        assertEquals(pageManager.getPageMySettings().getNickName(),"aotu12345aotu");
    }
}
