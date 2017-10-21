package appium1.testcases.favorites;

import appium1.common.BasicTestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToFavorite extends BasicTestCase{

    @Test

    public void testAddToFavorite() throws Exception {
        pageManager.getPageCommon().goToMySettingsTab();
        pageManager.getPageMySettings().clickLoginIcon();
        pageManager.getPageLogin().login("735723619@qq.com","12345678");
        pageManager.getPageCommon().goToHomeTab();
        String expectedNewsTitle = pageManager.getPageHome().getNewsTitle(3);
        System.out.println(expectedNewsTitle + "------------------------------");
        pageManager.getPageHome().clickNewsTitle(3);
        pageManager.getPageNewsDetail().clickAddToFavoriteBtn();
        Thread.sleep(3000);
        pageManager.getPageCommon().goBack();
        pageManager.getPageCommon().goToMySettingsTab();
        pageManager.getPageMySettings().clickFavoritesLayout();
        assertTrue(expectedNewsTitle.contains(pageManager.getPageUserFavoriteList().getFavoritesTitle(1)));
//        assertEquals(pageManager.getPageUserFavoriteList().getFavoritesTitle(1),expectedNewsTitle);
    }
}
