package day02;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-13 11:26
 * @Desc：弹窗使用异常捕获
 **/
public class toastDemo {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.ganji.android.haoche_c");
        desiredCapabilities.setCapability("appActivity","com.ganji.android.haoche_c.ui.main.MainActivity");
        desiredCapabilities.setCapability("noReset",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //弹窗使用异常捕获
        try {
            driver.findElement(By.xpath("//android.widget.TextView[@text='二手车']")).click();
        }catch (Exception e){
            driver.findElement(By.id("com.ganji.android.haoche_c:id/img_close")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='二手车']")).click();
        }
        Thread.sleep(3000);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"2016年/6.1万公里\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"我要预约\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"请输入您的手机号\")")).sendKeys("13333333333");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"下一步\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"请选择时间)\")")).click();
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        Thread.sleep(3000);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"05月21日 \")")).click();
        //String pageSource = driver.getPageSource();
        //System.out.println(pageSource);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"下午\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"确定\")")).click();



    }
}
