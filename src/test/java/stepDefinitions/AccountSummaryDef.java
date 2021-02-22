package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;

public class AccountSummaryDef {

    @Given("user login with valid data")
    public void user_login_with_valid_data() {
        // Write code here that turns the phrase above into concrete actions
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);
    }

    @When("the user go to dashboard")
    public void the_user_go_to_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().findElement(By.cssSelector("li#account_summary_tab")).click();
    }

    @Then("the page title should be correct")
    public void the_page_title_should_be_correct() {
        // Write code here that turns the phrase above into concrete actions
        String expectedTitle = "Zero – Account Summary";
        String actualTitle = Driver.get().getTitle();
        System.out.println(expectedTitle);
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
        Driver.closeDriver();
    }

    @Then("there should be {string}")
    public void there_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        String type = null;
        switch (string){
            case "Cash Accounts":
                type = Driver.get().findElement(By.xpath("//h2[contains(text(),'Cash')]")).getText();
                break;
            case "Investment Accounts":
                type = Driver.get().findElement(By.xpath("//h2[contains(text(),'Investment')]")).getText();
                break;
            case"Credit Accounts":
                type = Driver.get().findElement(By.xpath("//h2[contains(text(),'Credit')]")).getText();
                break;
            case "Loan Accounts":
                type = Driver.get().findElement(By.xpath("//h2[contains(text(),'Loan')]")).getText();
                break;
            default:
                type = type;
        }
        Assert.assertEquals(string,type);
        Driver.closeDriver();

    }

    @Then("credit accounts should have {string}")
    public void credit_accounts_should_have(String string) {
        // Write code here that turns the phrase above into concrete actions
        String column = null;
        switch (string){
            case "Account":
                column = Driver.get().findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/table/thead/tr/th[1]")).getText();
                break;
            case "Credit Card":
                column = Driver.get().findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/table/thead/tr/th[2]")).getText();
                break;
            case "Balance":
                column = Driver.get().findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/table/thead/tr/th[3]")).getText();
                break;
            default:column = null;
        }
        Assert.assertEquals(string,column);
        Driver.closeDriver();
    }

    @Then("account dropdown default option should be {string}")
    public void account_dropdown_default_option_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        Select account = new Select(Driver.get().findElement(By.cssSelector("select#aa_accountId")));
        String defaultOption = account.getFirstSelectedOption().getText();
        Assert.assertEquals("Savings",defaultOption);

    }

    @Then("account dropdown options should be full")
    public void account_dropdown_options_should_be_full() {
        // Write code here that turns the phrase above into concrete actions
        Select account = new Select(Driver.get().findElement(By.cssSelector("select#aa_accountId")));
        ArrayList<WebElement> allOptions = (ArrayList) account.getOptions();
        String options = "";
        for (WebElement allOption : allOptions) {
           options = options + allOption.getText();
        }
        System.out.println("options = " + options);
        Assert.assertTrue(options.contains("Savings, Checking, Loan, Credit Card, Brokerage"));
    }


    @Then("transaction table should have {string}")
    public void transaction_table_should_have(String string) {
        // Write code here that turns the phrase above into concrete actions
        String column = null;
        switch (string){
            case "Date":
                column = Driver.get().findElement(By.xpath("//*[@id=\"all_transactions_for_account\"]/table/thead/tr/th[1]")).getText();
                break;
            case "Description":
                column = Driver.get().findElement(By.cssSelector("#all_transactions_for_account > table > thead > tr > th:nth-child(2)")).getText();
                break;
            case "Deposit":
                column = Driver.get().findElement(By.xpath("//*[@id=\"all_transactions_for_account\"]/table/thead/tr/th[3]")).getText();
                break;
            case "Withdrawal":
                column = Driver.get().findElement(By.xpath("//*[@id=\"all_transactions_for_account\"]/table/thead/tr/th[4]")).getText();
                break;
            default:column = null;
        }
        Assert.assertEquals(string,column);
        Driver.closeDriver();
    }




}
