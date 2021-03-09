package com.browserstack.steps;

import com.browserstack.base.AppFactory;
import com.browserstack.pageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class StepDefinations {
    private HomePage homePage;
    private String input = "demoText";

    @Given("When User launches the app on {string}")
    public void when_user_launches_the_app(String deviceName) throws IOException {
        AppFactory.launchApp(deviceName);
        System.err.format("Thread ID - %2d",
                Thread.currentThread().getId());
        homePage = new HomePage();
    }

    @And("User navigates to EchoBox")
    public void user_navigates_to_echo_box() throws InterruptedException {
        Thread.sleep(3000);
        homePage.navigateToEchoBox();
    }
    @And("User enters a text and Saves it")
    public void user_enters_a_text_and_saves_it() throws InterruptedException {
        homePage.enterSomething(input);
        homePage.saveText();
    }
    @Then("User is able to save the text")
    public void user_is_able_to_save_the_text() {
        homePage.verifySavedText(input);
    }
    @After
    public void tearDown(){
       AppFactory.closeApp();
    }

}
