package day01;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-08 13:39
 * @Desc：
 **/
public class AppAutoDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity","com.lemon.lemonban.activity.WelcomeActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,desiredCapabilities);
        //隐式等待
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //点击题库
        //driver.findElement(MobileBy.AccessibilityId("题库")).click();
        driver.findElement(By.id("com.lemon.lemonban:id/navigation_tiku")).click();
        //点击去登录
        driver.findElement(By.xpath("//android.widget.Button[@text='去登录']")).click();
        Thread.sleep(1000);
        //输入账号
        driver.findElement(By.id("com.lemon.lemonban:id/et_mobile")).sendKeys("13989830373");
        //输入密码
        driver.findElement(By.id("com.lemon.lemonban:id/et_password")).sendKeys("830373");
        //点击登录按钮
        driver.findElement(By.id("com.lemon.lemonban:id/btn_login")).click();
        //点击软件测试基础
        driver.findElement(By.id("com.lemon.lemonban:id/fragment_category_description")).click();
        //点击初级
        driver.findElement(By.id("com.lemon.lemonban:id/first_level")).click();
        //点击软件测试基础--初级--第1套
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"软件测试基础--初级--第1套\")")).click();
        //点击显示答案
        driver.findElement(By.id("com.lemon.lemonban:id/switch_button")).click();

    }
}
