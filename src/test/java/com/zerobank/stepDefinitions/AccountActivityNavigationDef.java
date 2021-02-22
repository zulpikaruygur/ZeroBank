package com.zerobank.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.zerobank.utilities.Driver;

public class AccountActivityNavigationDef {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        // Write code here that turns the phrase above into concrete actions

        switch (string){
            case "Savings":
                Driver.get().findElement(By.xpath("(//table)[1]//tbody//tr[1]//td[1]/a")).click();
                break;
            case "Brokerage":
                Driver.get().findElement(By.xpath("(//table)[2]//tbody//tr[1]//td[1]/a")).click();
                break;
            case"Checking":
                Driver.get().findElement(By.xpath("(//table)[3]//tbody//tr[1]//td[1]/a")).click();
                break;
            case"Credit Card":
                Driver.get().findElement(By.xpath("(//table)[3]//tbody//tr[2]//td[1]/a")).click();
                break;
            case"Loan":
                Driver.get().findElement(By.xpath("(//table)[4]//tbody//tr[1]//td[1]/a")).click();
                break;
            default:;

        }
    }

    @Then("the title should be Zero - Account Activity")
    public void the_title_should_be_Zero_Account_Activity() {
        // Write code here that turns the phrase above into concrete actions
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        // Write code here that turns the phrase above into concrete actions
        Select options = new Select(Driver.get().findElement(By.cssSelector("select#aa_accountId")));
        String defaultOption = options.getFirstSelectedOption().getText();
        Assert.assertEquals(string,defaultOption);
        Driver.closeDriver();
    }



}