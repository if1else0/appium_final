package appium1.chapter1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class HelloWorld {
    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        //构造被测试应用的路径
        File app = new File(System.getProperty("user.dir"), "AUT/osc.apk");
        //实例化DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //deviceName的值可以任意指定
        capabilities.setCapability("deviceName", "My Device");
        //设置被测应用的绝对路径
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "net.oschina.app");
        //设置启动类的信息，这个信息可以通过aapt dump bading apkname来获得
        capabilities.setCapability("appActivity", ".AppStart");
        capabilities.setCapability("unicodeKeyboard",true);
        //初始化AppiumDriver
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testName() throws Exception {
        //两种写法是等价的
//        WebElement myTab1 = driver.findElementById("net.oschina.app:id/nav_item_me");
//        WebElement myTab2 = driver.findElement(By.id("net.oschina.app:id/nav_item_me"));
//        WebElement tab = (WebElement) driver.findElementsById("net.oschina.app:id/nav_tv_title").get(1);
//        WebElement tab2 = (WebElement) driver.findElements(By.id("net.oschina.app:id/nav_tv_title")).get(1);
//        System.out.println(tab.getText());
//        WebElement tabItem = (WebElement) driver.findElements(By.className("android.widget.TextView")).get(2);
//        System.out.println(tabItem.getText());
        Thread.sleep(3000);
//         WebElement tab = driver.findElement(By.xpath("//android.widget.TextView[@text='活动']"));
//         tab.click();
//         Thread.sleep(8000);
        WebElement tab = driver.findElement(By.xpath("//android.widget.TextView[@text='我的']"));
        tab.click();
        WebElement myMsg = driver.findElement(By.xpath("//android.widget.TextView[@text='我的消息']"));
        myMsg.click();
        WebElement name = driver.findElement(By.id("net.oschina.app:id/et_username"));
        name.sendKeys("你好吗");
        Thread.sleep(3000);
        name.clear();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
