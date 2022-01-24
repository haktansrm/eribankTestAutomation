package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import resources.BaseTest;

import java.time.Duration;

public class LoginPage extends BaseTest {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(15)),this);
    }

    @AndroidFindBy(id="usernameTextField")
    MobileElement txtUsername;

    @AndroidFindBy(id="passwordTextField")
    MobileElement txtPassword;

    @AndroidFindBy(id="loginButton")
    MobileElement btnLogin;

    public void LoginUser(){
        txtUsername.sendKeys("company");
        txtPassword.sendKeys("company");
        btnLogin.click();
    }
}
