package appium1.pages;

import appium1.common.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageNewsDetail {
    private Helper helper;

    public PageNewsDetail(Helper helper){
        this.helper = helper;
    }

    public WebElement getBackImageButton(){
        WebElement actionBar = helper.findById("net.oschina.app:id/action_bar_container");

        WebElement viewGroup =actionBar.findElement(By.id("net.oschina.app:id/decor_content_parent"));
        WebElement element = viewGroup.findElement(By.id("net.oschina.app:id/action_bar"));
        return  element.findElements(By.className("android.widget.ImageButton")).get(1);
    }

    public WebElement getAddToFavoriteBtn(){
        return helper.findById("net.oschina.app:id/iv_fav");
    }

    public WebElement getShareBtn(){
        return helper.findById("net.oschina.app:id/iv_share");
    }

    public WebElement getShareToWechatGroup(){
        return helper.findById("net.oschina.app:id/ly_share_weichat_circle");
    }


    public void clickBackImageButton(){
       helper.click(getBackImageButton());
    }

    public void clickAddToFavoriteBtn(){
        helper.click(getAddToFavoriteBtn());
    }

    public void clickShareBtn(){
        helper.click(getShareBtn());

    }

    public void clickShareToWechatGroup(){
        helper.click(getShareToWechatGroup());
    }

}
