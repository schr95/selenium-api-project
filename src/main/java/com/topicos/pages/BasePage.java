package com.topicos.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage{
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPage(String url) {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void closePage() {
        driver.quit();
    }
}
