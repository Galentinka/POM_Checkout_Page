package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;

    @FindBy(linkText = "HP LP3065")
    private WebElement HPLaptop;

    @FindBy(xpath = "//div[@class='button-group']//button[1]")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayStatusOfHPLaptop(){
        boolean status = HPLaptop.isDisplayed();
        return status;
    }

    public AddToCartDetailsPage navigateDetailsPage() {
        addToCartButton.click();
        return new AddToCartDetailsPage(driver);
    }
}
