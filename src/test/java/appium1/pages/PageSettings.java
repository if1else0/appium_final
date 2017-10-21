package appium1.pages;

import appium1.common.Helper;
import org.openqa.selenium.WebElement;

public class PageSettings {
    private Helper helper;

    public PageSettings(Helper helper){
        this.helper = helper;
    }

    public WebElement getLogoutBtn(){
       return helper.findById("net.oschina.app:id/rl_cancle");
    }

    public WebElement getAboutUs(){
        return helper.findById("net.oschina.app:id/rl_about");
    }

    public void clickLogoutBtn(){
        helper.click(getLogoutBtn());
    }

    public void clickAboutUs(){
        helper.click(getAboutUs());
    }
}
