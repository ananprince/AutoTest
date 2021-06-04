package com.lemon.testcase;

import com.lemon.base.Assetion;
import com.lemon.base.BasePage;
import com.lemon.base.BaseTest;
import com.lemon.datas.Constant;
import com.lemon.pages.IndexPage;
import com.lemon.pages.LoginPage;
import com.lemon.pages.QuitLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 13:24
 * @Desc：
 **/
public class TestLogin extends BaseTest{
    @BeforeMethod
    public void setUp(){
        //前置

    }
    @Test
    public void testLogin(){
        //首页点击我的柠檬
        IndexPage indexPage = new IndexPage();
        indexPage.clickLemon();
        indexPage.clickTouxiang();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USER_NAME,Constant.PASSWORD);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //断言
        String value = ".activity.MainActivity";
        String currentValue = driver.currentActivity();
        Assetion.myAssertEquals(value,currentValue);
    }
    @AfterMethod
    public void tearDown(){
        //先进入我的柠檬
        IndexPage indexPage = new IndexPage();
        indexPage.clickLemon();
        //然后退出登录操作
        QuitLoginPage quitLoginPage = new QuitLoginPage();
        quitLoginPage.clickSet();
    }
}
