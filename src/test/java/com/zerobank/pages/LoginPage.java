package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){PageFactory.initElements(Driver.get(), this);}

    @FindBy(css ="button#signin_button")
    public WebElement loginBtn;

    @FindBy(css = "input#user_login")
    public WebElement userName;

    @FindBy(css="input#user_password")
    public WebElement password;

    @FindBy(css = "input#user_remember_me")
    public WebElement rememberMe;

    @FindBy(css = "input[type=\"submit\"]")
    public WebElement submit;

    @FindBy(css = "button#details-button")
    public WebElement details;

    @FindBy(css = "a#proceed-link")
    public WebElement procedd;


    public void login(String userNameStr, String passwordStr) {
        loginBtn.click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        rememberMe.click();
        submit.click();
        details.click();
        procedd.click();

        // verification that we logged
    }

    public void invalidLogin (String userNameStr, String passwordStr){
        loginBtn.click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        rememberMe.click();
        submit.click();
    }


}
