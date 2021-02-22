package com.zerobank.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user enters valid information")
    public void the_user_enters_valid_information() {
        // Write code here that turns the phrase above into concrete actions
        String userName = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertEquals(expectedUrl,actualUrl);
        Driver.closeDriver();
    }

    @When("the user enters invalid information")
    public void the_user_enters_invalid_information() {
        // Write code here that turns the phrase above into concrete actions
        String userName = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        LoginPage loginPage = new LoginPage();
        loginPage.invalidLogin(userName+"a",password+"b");
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        String expectedMsg = "Login and/or password are wrong.";
        String actualMsg = Driver.get().findElement(By.cssSelector("div.alert.alert-error")).getText();
        Assert.assertEquals(expectedMsg,actualMsg);
        Driver.closeDriver();
    }
}
