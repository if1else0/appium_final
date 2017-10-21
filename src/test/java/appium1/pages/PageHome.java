package appium1.pages;

import appium1.common.Helper;
import org.openqa.selenium.WebElement;

public class PageHome {
    private Helper helper;

    public PageHome(Helper helper){
        this.helper = helper;
    }

    public WebElement getNewsTitleTextView(int index){
        return helper.findById("net.oschina.app:id/tv_title",index);
    }

    public String getNewsTitle(int index){
        return helper.getText(getNewsTitleTextView(index));
    }

    public void clickNewsTitle(int index){
        helper.click(getNewsTitleTextView(index));
    }

}
