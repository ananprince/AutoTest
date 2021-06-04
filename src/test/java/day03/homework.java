package day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-15 09:34
 * @Desc：
 **/
public class homework {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity","com.lemon.lemonban.activity.WelcomeActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(url,desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"柠檬社区\")")).click();
        //获取全部页面
        Set<String> contextAll = androidDriver.getContextHandles();
        Thread.sleep(1000);
        //原生页面转换WEBVIEW
        for (String context :
                contextAll) {
            if(context.contains("WEBVIEW")){
                androidDriver.context(context);
            }
        }

        //点击登录按钮
        androidDriver.findElement(By.xpath("//div[@class='index-bottom']/a[4]")).click();
        Thread.sleep(1000);
        //androidDriver.findElement(MobileBy.xpath("//input[@autofocus='autofocus']")).sendKeys("13989830373");
        //androidDriver.findElement(MobileBy.xpath("//input[@onfocus=\"this.removeAttribute('readonly');\"]")).sendKeys("lca1990714");
        //androidDriver.findElement(MobileBy.xpath("//div[text()='登录']")).click();
    }

}
