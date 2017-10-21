package appium1.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicTestCase {
    private static AppiumDriver driver;
    private Helper helper;
    public PageManager pageManager;

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
        helper =  new Helper(driver);
        pageManager = new PageManager(helper);
        pageManager.getPageCommon().goToMySettingsTab();
        if("aotu12345aotu".equals(pageManager.getPageMySettings().getNickName())){
            pageManager.getPageMySettings().clickSettingsBtn();
            pageManager.getPageSettings().clickLogoutBtn();
        }
        pageManager.getPageCommon().goToHomeTab();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }


    public static  void captureScreenShot(ITestResult result) {
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
        // To capture screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String  destDir = "screenshots/Failures";
        new File(destDir).mkdirs();
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
