package com.lemon.listeners;

import com.lemon.base.BaseTest;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 14:48
 * @Desc：监听器
 **/
public class Listener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        System.out.println("当前是IHookable接口的run方法执行");
        iHookCallBack.runTestMethod(iTestResult);
        if(iTestResult.getThrowable()!=null){
            byte[] screenshot = BaseTest.getScreenshotAsByte();
            saveScreenshotToAllure(screenshot);
        }

    }
    @Attachment
    public byte[] saveScreenshotToAllure(byte[] data){
        return data;
    }
}
