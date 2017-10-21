package appium1.pages;

import appium1.common.Helper;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.openqa.selenium.WebElement;

public class PageUserFavoriteList {
    private Helper helper;

    public PageUserFavoriteList(Helper helper){
        this.helper = helper;
    }

    public WebElement getFavoritesTitleTextView(int index){
        return helper.findById("net.oschina.app:id/tv_favorite_title",index);
    }

    public String getFavoritesTitle(int index){
        return helper.getText(getFavoritesTitleTextView(index));
    }
}
