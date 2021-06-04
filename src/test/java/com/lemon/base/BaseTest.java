package com.lemon.base;

import com.lemon.datas.Constant;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 11:31
 * @Desc：测试父类
 **/
public class BaseTest {
    Logger logger = Logger.getLogger(BaseTest.class);
    @BeforeSuite
    public void globalSetUp(){
        openApp();
        implicitlyWait(8);
    }
    @AfterSuite
    public void globalTearDown(){
        closeApp();
    }

    public static AndroidDriver driver;
    public void openApp(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", Constant.DEVICE_NAME);
        desiredCapabilities.setCapability("platformName",Constant.PLATFORM_NAME);
        desiredCapabilities.setCapability("appPackage",Constant.PACKAGE_NAME);
        desiredCapabilities.setCapability("appActivity",Constant.ACTIVITY_NAME);
        URL url = null;
        try {
            url = new URL("http://"+Constant.IP_NAME+":"+Constant.PORT_NAME+"/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(url,desiredCapabilities);
    }
    /**
     * 生成字节数组截图的封装
     */
    public static byte[] getScreenshotAsByte(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //1、file对象
        //2、字节数组
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
    //退出封装
    public void closeApp(){
        try {
            driver.quit();
            logger.info("退出登录页面成功");
        }catch (Exception e){
            logger.error("退出登录异常");
            logger.error(e);
            throw e;
        }

    }
    //隐式等待
    public void implicitlyWait(int timesOut){
        try{

            driver.manage().timeouts().implicitlyWait(timesOut, TimeUnit.SECONDS);
            logger.info("隐式等待【"+timesOut+"】秒");
        }catch (Exception e){
            logger.info("隐式等待失败");
            logger.error(e);
            throw e;
        }

    }
}
