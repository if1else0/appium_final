package appium1.pages;

import appium1.common.Helper;
import com.sun.xml.internal.ws.server.sei.MessageFiller;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class PageMySettings {
    private Helper helper;

    public PageMySettings(Helper helper){
        this.helper = helper;
    }

    /**
     *
     * 控件 定位
     */


    public WebElement getSettingsBtn(){
        return helper.findById("net.oschina.app:id/iv_logo_setting");
    }

    public WebElement getLoginIcon(){
        return helper.findById("net.oschina.app:id/iv_portrait");
    }

    public WebElement getMyMsgItem(){
        return helper.findById("net.oschina.app:id/rl_message");
    }

    public WebElement getMyBlogItem(){
        return helper.findById("net.oschina.app:id/rl_blog");
    }

    public WebElement getMyActivitiesItem(){
        return  helper.findById("net.oschina.app:id/rl_info_avtivities");
    }

    public WebElement getMyTeamItem(){
        return helper.findById("net.oschina.app:id/rl_team");
    }

    public WebElement getNickNameTextView(){
        return helper.findById("net.oschina.app:id/tv_nick");
    }

    public WebElement getFavoritesLayout(){
        return helper.findById("net.oschina.app:id/ly_favorite");
    }

    /*
    控件操作
     */

    public void clickSettingsBtn(){
        helper.click(getSettingsBtn());
    }

    public void clickLoginIcon(){
        helper.click(getLoginIcon());
    }

    public void clickMyMsgItem(){
        helper.click(getMyBlogItem());
    }

    public void clickMyBlogItem(){
        helper.click(getMyMsgItem());
    }

    public void clickMyActivitiesItem(){
        helper.click(getMyActivitiesItem());
    }

    public void clickMyTeamItem(){
        helper.click(getMyTeamItem());
    }

    public String getNickName(){
        return helper.getText(getNickNameTextView());
    }

    public void clickFavoritesLayout(){
        helper.click(getFavoritesLayout());
    }
}
