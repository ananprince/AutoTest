package day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-17 11:25
 * @Desc：
 **/
public class SmallRoutineTest {
    static AndroidDriver androidDriver;
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackAge","com.tencent.mm");
        desiredCapabilities.setCapability("appActivity","com.tencent.mm.ui.LauncherUI");
        desiredCapabilities.setCapability("noReset",true);
        desiredCapabilities.setCapability("recreateChromeDriverSessions",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        androidDriver = new AndroidDriver(url,desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //调用滑动方法，持续时间3秒
        swipeDown(3000);


    }
    //向下滑动页面
    public static void swipeDown(long times) {
        int width = androidDriver.manage().window().getSize().getWidth();
        int height = androidDriver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption startPoint = PointOption.point(width / 2, height / 4);
        PointOption endPoint = PointOption.point(width / 2, 3 * height / 4);
        //持续时间
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }
}
