package com.niki.bjetf.android.tests.steps;

import com.niki.bjetf.android.tests.hooks.AndroidInitializer;
import com.niki.bjetf.androidmobile.pages.actions.ChatActions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

import java.util.Random;

public class ChatSteps {
    private AndroidDriver driver;
  private ChatActions chatActions;

    public ChatSteps() {

        driver = AndroidInitializer.getAndroiddriver();
        chatActions = new ChatActions(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), chatActions);

    }




    @Given("^I enter the username to start chat$")
    public void I_enter_the_username_to_start_chat() throws Throwable {

        chatActions.enterUsername();
    }

    @Then("^I click on the added user$")
    public void I_click_on_the_added_user() throws Throwable {
        chatActions.clickOnUser();

    }
    @And("^I navigate to chat window of the user and send chat$")
    public void I_navigate_to_chat_window_of_the_user_and_send_chat() throws Throwable {
        chatActions .navigateToChat();

    }

}