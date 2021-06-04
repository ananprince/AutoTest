package day02;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-14 11:15
 * @Desc：
 **/
public class xiaomiyoupinDemo {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackAge","com.ganji.android.haoche_c");
        desiredCapabilities.setCapability("appActivity","com.ganji.android.haoche_c.ui.main.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(url,desiredCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);


    }
}
