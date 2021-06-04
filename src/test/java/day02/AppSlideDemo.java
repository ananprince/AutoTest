package day02;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-05-13 10:08
 * @Desc：滑动APP页面
 **/
public class AppSlideDemo {
    static AndroidDriver driver;
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity","com.lemon.lemonban.activity.WelcomeActivity");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(url,desiredCapabilities);
        //隐式等待
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.id("com.lemon.lemonban:id/navigation_tiku")).click();
        //点击去登录
        driver.findElement(By.xpath("//android.widget.Button[@text='去登录']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        Thread.sleep(3000);
        //滑动前和滑动后对比一致就跳出循环
        while(true){
            String before = driver.getPageSource();
            swipeDown(1000);
            if(before.contains("软件测试基础--初级--第23套")){
                driver.findElement(MobileBy.AndroidUIAutomator
                        ("new UiSelector().text(\"软件测试基础--初级--第23套\")")).click();
            }
            Thread.sleep(1000);
            String after = driver.getPageSource();
            if(before.equals(after)){
                break;
            }


        }

    }

    //下拉刷新
        public static void swipeDown(long times){
            //获取屏幕宽度
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();
            //鼠标操作
            TouchAction touchAction = new TouchAction(driver);
            //获取开始滑动的点位
            PointOption startPoint = PointOption.point(width/2,height/4);
            //获取滑动结束的点位
            PointOption endPoint = PointOption.point(width/2,height*3/4);
            //加入等待时间
            Duration duration = Duration.ofMillis(times);
            WaitOptions waitOptions = WaitOptions.waitOptions(duration);
            //滑动
            touchAction.press(endPoint).waitAction(waitOptions).moveTo(startPoint).release().perform();

        }
}
