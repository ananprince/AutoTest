package com.lemon.base;

import com.lemon.datas.Constant;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 11:37
 * @Desc：点击操作二次封装
 **/
public class BasePage {
    Logger logger = Logger.getLogger(BasePage.class);

    /**
     * 点击操作
     * @param by
     * @param desc
     */
    public void click(By by,String desc){
        try {
            BaseTest.driver.findElement(by).click();
            logger.info("点击了元素【"+desc+"】");
        }catch (Exception e){
            logger.error("定位元素失败【"+desc+"】");
            logger.error(e);
            throw e;
        }
    }

    /**
     * 输入操作
     * @param by
     * @param data
     * @param desc
     */
    public void input(By by,String data,String desc){
        try{
            //显式等待
            WebDriverWait wait = new WebDriverWait(BaseTest.driver,5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            BaseTest.driver.findElement(by).sendKeys(data);
            logger.info("往元素【"+desc+"】输入了【"+data+"】");
        }catch (Exception e){
            logger.error("定位元素异常【"+desc+"】");
            logger.error(e);
            throw e;
        }

    }



    /**
     * 从APP的任意页面返回到首页
     */
    public void backToIndex(){
        Activity activity = new Activity(Constant.PACKAGE_NAME,Constant.ACTIVITY_NAME);
        BaseTest.driver.startActivity(activity);
        logger.info("返回到首页");
    }
}
