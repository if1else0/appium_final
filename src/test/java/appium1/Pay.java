package appium1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class Pay {
    private AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() throws Exception {
        File app = new File(System.getProperty("user.dir"), "AUT/wechat.apk");
//        File chromeDriver = new File(System.getProperty("user.dir"), "AUT/chromedriver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "My Device");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.tencent.mm");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appActivity", ".ui.LauncherUI");
//        capabilities.setCapability("chromedriverExecutable", chromeDriver.getAbsolutePath());
//        capabilities.setCapability("recreateChromeDriverSessions", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testName() throws Exception {
        driver.findElement(By.xpath("//*[@text='Any']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@text='帮我付款才是真友谊']"));
        list.get(list.size() - 1).click();
        Thread.sleep(8000);
//        Set<String> contextNames = driver.getContextHandles();
//        for (String contextName : contextNames) {
//            System.out.println(contextName);
//        }
        driver.context("WEBVIEW_com.tencent.mm:tools");
        WebElement payBtn = driver.findElement(By.cssSelector("a[class='next btn SEND_PAY']"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(15000);
        driver.quit();
    }


}

