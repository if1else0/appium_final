package appium1.common;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.WebGLBuffer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;

public class Helper {
    private AppiumDriver driver;
    private final long DEFAULT_TIMEOUT = 5;
    private final long LONG_TIMEOUT = 10;

    public  Helper(AppiumDriver driver){
        this.driver = driver;
    }

    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementForLongTime(By by){
        WebDriverWait wait = new WebDriverWait(driver,LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * 封装常见定位方法
     */

    //按id定位
    public WebElement findById(String id){
        waitForElement(By.id(id));
        return driver.findElement(By.id(id));
    }

    //多个相同id的定位方法，index从0开始
    public WebElement findById(String id,int index){
        waitForElement(By.id(id));
        return (WebElement) driver.findElements(By.id(id)).get(index - 1);
    }

    //按控件类型定位
    public WebElement findByClassName(String clsName,int index){
        waitForElement(By.className(clsName));
        return  (WebElement) driver.findElements(By.className(clsName)).get(index - 1);
    }

    //按文本定位
    public WebElement findByText(String text){
        waitForElement(By.xpath("//*[@text='"+text+"']"));
        return driver.findElement(By.xpath("//*[@text='"+text+"']"));
    }

    public WebElement findByText(String text,int index){
        waitForElement(By.xpath("//*[@text='"+text+"']"));
        return (WebElement) driver.findElements(By.xpath("//*[@text='"+text+"']")).get(index - 1);
    }

    //常见控件的定位方式
    public void click(WebElement element){
        System.out.println("执行控件点击操作--->");
        element.click();
    }

    public void enterText(WebElement element,String text){
        System.out.println("执行输入操作，输入文本为"+text+"--->");
        element.sendKeys(text);
    }

    public void clearText(WebElement element){
        System.out.println("执行清空输入框操作--->");
        element.clear();
    }

    public void enterTextWithPreClear(WebElement element,String text){
        clearText(element);
        enterText(element,text);
    }

    public String  getText(WebElement element){
        System.out.println("执行如下操作：获取控件文本--->");
        return  element.getText();
    }

    public void goBack(){
        driver.navigate().back();
    }

}
