package day02;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-14 11:15
 * @Desc：
 **/
public class JdDemo {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackAge","com.jingdong.app.mall");
        desiredCapabilities.setCapability("appActivity","com.jingdong.app.mall.main.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(url,desiredCapabilities);


    }
}
