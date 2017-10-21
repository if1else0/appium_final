package appium1.pages;

import appium1.common.Helper;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebElement;

public class PageCommon {
    private Helper helper;

    public PageCommon(Helper helper){
        this.helper = helper;
    }

    public WebElement getHomeTab(){
       return helper.findById("net.oschina.app:id/nav_item_news");
    }

    public WebElement getMomentTab(){
        return helper.findById("net.oschina.app:id/nav_item_tweet");
    }

    public WebElement getPublishBtn(){
        return helper.findById("net.oschina.app:id/nav_item_tweet_pub");
    }

    public WebElement getExploreTab(){
        return helper.findById("net.oschina.app:id/nav_item_explore");
    }

    public WebElement getMySettingsTab(){
        return helper.findById("net.oschina.app:id/nav_item_me");
    }

    public void goToHomeTab(){
        helper.click(getHomeTab());
    }

    public void goToMomentTab(){
        helper.click(getMomentTab());
    }

    public void clickPublishBtn(){
        helper.click(getPublishBtn());
    }

    public void goToExploreTab(){
        helper.click(getExploreTab());
    }

    public void goToMySettingsTab(){
        helper.click(getMySettingsTab());
    }

    public void goBack(){
        helper.goBack();
    }
}
