package com.topicos.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='userName']")
    public WebElement inputUser;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@id='login']")
    public WebElement buttonLogin;

    @FindBy(xpath ="//p[@id='name']")
    public WebElement infoMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUser(String user){
        inputUser.sendKeys(user);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickLogin(){
        buttonLogin.click();
    }

    public void loginUser(String user,String password){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputUser);
        inputUser.sendKeys(user);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public String getInfoMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOf(infoMessage)).getText();
    }
}
