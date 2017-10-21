package appium1.pages;

import appium1.common.Helper;
import org.openqa.selenium.WebElement;

public class PageAbout {

    private Helper helper;
    public PageAbout(Helper helper){
        this.helper = helper;
    }

    public WebElement getAppVersionTextView(){
        return helper.findById("net.oschina.app:id/tv_version_name");
    }

    public String  getAppVersionValue(){
        return helper.getText(getAppVersionTextView());
    }

}
