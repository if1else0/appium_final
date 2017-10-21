package appium1.pages;

import appium1.common.Helper;
import org.openqa.selenium.WebElement;

public class PageLogin {
    private Helper helper;

    public PageLogin(Helper helper){
        this.helper = helper;
    }

    public WebElement getNameEditText(){
        return  helper.findById("net.oschina.app:id/et_username");
    }

    public WebElement getPwdEditText(){
        return helper.findById("net.oschina.app:id/et_password");
    }

    public WebElement getLoginBtn(){
        return helper.findById("net.oschina.app:id/btn_login");
    }

    public WebElement getBackImageButton(){
        return helper.findByClassName("android.widget.ImageButton",1);
    }

    public void enterName(String name){
        helper.enterText(getNameEditText(),name);
    }

    public void entPwd(String password){
        helper.enterText(getPwdEditText(),password);
    }

    public void clickLoginBtn(){
        helper.click(getLoginBtn());
    }

    public void clearName(){
        helper.clearText(getNameEditText());
    }

    public void clearPwd(){
        helper.clearText(getPwdEditText());
    }

    public void login(String name,String pwd){
        helper.enterTextWithPreClear(getNameEditText(),name);
        helper.enterTextWithPreClear(getPwdEditText(),pwd);
        clickLoginBtn();
    }


    public boolean isLoginPage(){
        boolean result = false;
        if(getNameEditText().isDisplayed() && getNameEditText().isEnabled()){
            return true;
        }
        return result;
    }

    public void clickBackImageButton(){
        helper.click(getBackImageButton());
    }

}
