package appium1.testcases.versioncheck;

import appium1.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VersionCheck extends BasicTestCase {


    @Test
    public void testAppVersion() throws Exception {
        pageManager.getPageCommon().goToMySettingsTab();
        pageManager.getPageMySettings().clickSettingsBtn();
        pageManager.getPageSettings().clickAboutUs();
        assertEquals(pageManager.getPageAbout().getAppVersionValue(),"v2.8.9(1609281026)");
    }
}
