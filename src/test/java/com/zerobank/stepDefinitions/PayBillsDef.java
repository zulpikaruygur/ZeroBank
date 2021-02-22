package com.zerobank.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.zerobank.utilities.Driver;

public class PayBillsDef {

    @When("user click pay bills")
    public void user_click_pay_bills() {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().findElement(By.cssSelector("li#pay_bills_tab>a")).click();
    }

    @Then("the page title should be Zero - Pay Bills")
    public void the_page_title_should_be_Zero_Pay_Bills() {
        // Write code here that turns the phrase above into concrete actions
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Pay Bills";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user enter payment information and sumbit")
    public void user_enter_payment_information_and_sumbit() {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().findElement(By.cssSelector("input#sp_amount")).sendKeys("100");
        Driver.get().findElement(By.cssSelector("input#sp_date")).sendKeys("02-02-2020");
        Driver.get().findElement(By.cssSelector("input#pay_saved_payees")).click();
    }

    @Then("payment successful message display")
    public void payment_successful_message_display() {
        // Write code here that turns the phrase above into concrete actions
        String actualMsg = Driver.get().findElement(By.cssSelector("div#alert_content>span")).getText();
        String expectedMsg = "The payment was successfully submitted.";
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @When("user doesn't enter payment information and sumbit")
    public void user_doesn_t_enter_payment_information_and_sumbit() {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().findElement(By.cssSelector("input#pay_saved_payees")).click();
    }

    @Then("payment unsuccessful message display")
    public void payment_unsuccessful_message_display() {
        // Write code here that turns the phrase above into concrete actions

        String actualMsg = Driver.get().findElement(By.cssSelector("input#sp_date")).getAttribute("validationMessage");
        String expectedMsg = "Please fill out this field.";
        Assert.assertEquals(expectedMsg,actualMsg);
    }


}
