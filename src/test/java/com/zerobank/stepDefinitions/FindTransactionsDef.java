package com.zerobank.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

public class FindTransactionsDef {
    WebDriverWait wait = new WebDriverWait(Driver.get(),20);

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        Driver.get().findElement(By.cssSelector("li#account_activity_tab a")).click();
        Driver.get().findElement(By.cssSelector("li.ui-state-default.ui-corner-top a[href=\"#ui-tabs-2\"]")).click();

    }

//    @When("the user enters date range from <first begin> to <first end>")
//    public void the_user_enters_date_range_from_first_begin_to_first_end() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("clicks search")
//    public void clicks_search() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("results table should only show transactions dates between <first begin> to  <first end>")
//    public void results_table_should_only_show_transactions_dates_between_first_begin_to_first_end() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the results should be sorted by most recent date")
//    public void the_results_should_be_sorted_by_most_recent_date() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("the user enters date range from <second begin> to <second end>")
//    public void the_user_enters_date_range_from_second_begin_to_second_end() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("results table should only show transactions dates between <second begin> to  <second end>")
//    public void results_table_should_only_show_transactions_dates_between_second_begin_to_second_end() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the results table should only not contain transactions dated <first begin>")
//    public void the_results_table_should_only_not_contain_transactions_dated_first_begin() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//



    @When("the user enters description “ONLINE”")
    public void the_user_enters_description_ONLINE(){
        // Write code here that turns the phrase above into concrete actions
        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"text\"][name=\"description\"]")));
        inputBox.sendKeys("ONLINE");
    }

    @When("clicks search")
    public void clicks_search() {
        // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button"))).click();
    }

    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() {
        // Write code here that turns the phrase above into concrete actions
        String description = null;
        for (int i = 1; i < 3; i++) {
             description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]//tbody//tr[" + i + "]//td[2]"))).getText();
            Assert.assertTrue(description.contains("ONLINE"));


        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#aa_description"))).clear();
    }

    @When("the user enters description “OFFICE”")
    public void the_user_enters_description_OFFICE() {
        // Write code here that turns the phrase above into concrete actions
        //the_user_accesses_the_Find_Transactions_tab();
        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"text\"][name=\"description\"]")));
        inputBox.clear();
        inputBox.sendKeys("OFFICE");
        //Driver.get().findElement(By.cssSelector("button")).click();
    }

    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_OFFICE() {
        // Write code here that turns the phrase above into concrete actions
        String onlyOffice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#filtered_transactions_for_account > table > tbody > tr > td:nth-child(2)"))).getText();
        System.out.println("description = " + onlyOffice);
        Assert.assertFalse(onlyOffice.contains("OFFICE"));
    }

    @Then("results table should not show descriptions containing “OFFICE”")
    public void results_table_should_not_show_descriptions_containing_OFFICE() {
        // Write code here that turns the phrase above into concrete actions
        String description = Driver.get().findElement(By.xpath("(//table)[2]//tbody//tr[1]//td[2]")).getText();
        Assert.assertFalse(description.contains("OFFICE"));
    }

    @When("the user enters description “online”")
    public void the_user_enters_description_online() {
        // Write code here that turns the phrase above into concrete actions
        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#aa_description")));
        inputBox.sendKeys("online");
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        int count = 0;
        for (int i = 1; i < 4; i++) {
            WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]/tbody//tr[" + i + "]/td[3]")));
            if(!row.getText().isEmpty()){
                count ++;
            }
        }
        Assert.assertTrue(count >= 1);


    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        int count = 0;
        for (int i = 1; i < 4; i++) {
            WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]/tbody//tr[" + i + "]/td[4]")));
            if(!row.getText().isEmpty()){
                count ++;
            }
        }
        Assert.assertTrue(count >= 1);
    }

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        Select type = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#aa_type"))));
        type.selectByIndex(1);
        clicks_search();

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() throws AssertionError{
        // Write code here that turns the phrase above into concrete actions
        int count = 0;
        for (int i = 1; i < 4; i++) {
            WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]/tbody//tr[" + i + "]/td[4]")));
            if(!row.getText().isEmpty()){
                count ++;
            }
        }
        Assert.assertTrue(count < 1);
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        // Write code here that turns the phrase above into concrete actions
        Select type = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#aa_type"))));
        type.selectByValue("Withdrawal");
        clicks_search();
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        // Write code here that turns the phrase above into concrete actions
        int count = 0;
        for (int i = 1; i < 4; i++) {
            WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[2]/tbody//tr[" + i + "]/td[3]")));
            if(!row.getText().isEmpty()){
                count ++;
            }
        }
        Assert.assertTrue(count < 1);
    }


}