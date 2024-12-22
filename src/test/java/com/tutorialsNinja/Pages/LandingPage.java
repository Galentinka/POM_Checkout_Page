package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccountDropdown() {
        myAccountDropdown.click();
    }

    public void clickOnLoginOption() {
        loginOption.click();
    }

    public LoginPage clickOnMyAccountAndClickOnLogin() {
        myAccountDropdown.click();
        loginOption.click();

        return new LoginPage(driver);
    }
}
