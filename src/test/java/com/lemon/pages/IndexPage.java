package com.lemon.pages;

import com.lemon.base.BasePage;
import com.lemon.base.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 13:10
 * @Desc：首页
 **/
public class IndexPage extends BasePage{

    //我的柠檬
    By mylemonBy = MobileBy.AccessibilityId("我的柠檬");
    //头像点击
    By headIcon = By.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");

    /**
     * 点击我的柠檬
     */
    public void clickLemon(){
        click(mylemonBy,"首页_我的柠檬");
    }
    public void clickTouxiang(){
        click(headIcon,"首页_头像");
    }
}
