package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AccountActivityDef {


    @When("the user click Account activity")
    public void the_user_click_Account_activity() {
        // Write code here that turns the phrase above into concrete actions
        Driver.get().findElement(By.xpath("//a[contains(text(),\"Account Activity\")]")).click();
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        String currentTitle = Driver.get().getTitle();
        Assert.assertEquals(string,currentTitle);
    }



}
