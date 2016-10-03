package com.niki.bjetf.androidmobile.pages.repo;

import com.niki.bjetf.mobile.base.MobileUIBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidElement;


public class Chat extends MobileUIBase{



    @FindBy(id="com.nikiapp:id/login_username")
    protected WebElement username;

    @FindBy(id="com.nikiapp:id/startChatBtn")
    protected AndroidElement startChatButton;

    @FindBy(id="com.nikiapp:id/chatName")
    protected AndroidElement addedUser;

    @FindBy(id= "com.nikiapp:id/toolbar")
    protected AndroidElement toolbar;
}