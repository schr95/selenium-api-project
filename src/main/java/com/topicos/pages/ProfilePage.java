package com.topicos.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*[@id='userName-value']")
    public WebElement loggedUsername;

    @FindBy(xpath = "//button[@id='submit' and text()='Delete Account']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    public WebElement okDeleteButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserLogged(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOf(loggedUsername)).getText();
    }

    public void deleteAccount(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteAccount);
        deleteAccount.click();
        okDeleteButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
