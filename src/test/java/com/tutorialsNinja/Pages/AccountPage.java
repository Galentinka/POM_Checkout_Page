package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	public WebDriver driver;

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	@FindBy(name = "search")
	private WebElement searchTextBox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateDisplayStatusOfLogoutLink() {
		return logoutLink.isDisplayed();
	}

	public void enterProduct(String ProductText) {
		searchTextBox.sendKeys(ProductText);
	}

	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}

	public ProductPage navigateToProductPage(String ProductText) {
		searchTextBox.sendKeys(ProductText);
		searchButton.click();
		return new ProductPage(driver);
	}

}
