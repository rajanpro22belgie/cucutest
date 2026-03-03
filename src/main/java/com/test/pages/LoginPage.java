package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");
    private By errorMsg = By.id("error");

    public void open() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
    
    public String getErrorMessage() 
    { return driver.findElement(errorMsg).getText(); }
}
