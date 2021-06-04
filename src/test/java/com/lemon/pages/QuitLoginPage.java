package com.lemon.pages;

import com.lemon.base.BasePage;
import com.lemon.base.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 14:16
 * @Desc：
 **/
public class QuitLoginPage extends BasePage {
    //退出柠檬班按钮
    By setButtonBy = By.xpath("//*[@resource-id='com.lemon.lemonban:id/mypage_titlebar']//android.widget.ImageButton");
    By quitButtonBy = MobileBy.AndroidUIAutomator("new UiSelector().text(\"退出登录\")");
    By confirmBy = MobileBy.AndroidUIAutomator("new UiSelector().text(\"确定\")");

    public void clickSet(){
        click(setButtonBy,"退出首页_设置图标");
        click(quitButtonBy,"退出页面_退出登录按钮");
        click(confirmBy,"退出页面_确定按钮");
    }
}
