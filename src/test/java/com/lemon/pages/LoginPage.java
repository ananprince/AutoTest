package com.lemon.pages;

import com.lemon.base.BasePage;
import com.lemon.datas.Constant;
import org.openqa.selenium.By;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 13:17
 * @Desc：登录页面
 **/
public class LoginPage extends BasePage {
    By mobileBy = By.id("com.lemon.lemonban:id/et_mobile");
    By pwdBy = By.id("com.lemon.lemonban:id/et_password");
    By loginBy = By.id("com.lemon.lemonban:id/btn_login");
    public void login(String username,String pwd){
        input(mobileBy, username,"登录页面_手机号码");
        input(pwdBy, pwd,"登录页面_密码");
        click(loginBy,"登录页面_登录按钮");
    }


}
