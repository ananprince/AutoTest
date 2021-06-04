package day01;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-11 16:21
 * @Desc：
 **/
public class AppAutoDemo02 {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.ganji.android.haoche_c");
        desiredCapabilities.setCapability("appActivity","com.ganji.android.haoche_c.ui.main.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //截图
        //File file = driver.getScreenshotAs(OutputType.FILE);
        //File srcFile = new File("D:\\test.png");

        //FileUtils.copyFile(file,srcFile);
        //点击题库
        //driver.findElement(By.id("com.lemon.lemonban:id/navigation_tiku")).click();
        //Thread.sleep(1000);
        //点击同意并继续使用APP
        driver.findElement(By.id("com.ganji.android.haoche_c:id/btn_permit_goon")).click();
        //点击关闭按钮
        driver.findElement(By.id("com.ganji.android.haoche_c:id/img_close")).click();
        //点击二手车按钮
        driver.findElement(By.xpath("//android.widget.TextView[@text='二手车']")).click();

    }
}
