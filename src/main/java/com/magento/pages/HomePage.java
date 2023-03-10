package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='logo']")
	WebElement homepageLogo;

	@FindBy(xpath = "//a[contains(text(),'Create an Account')]")
	WebElement hpcreateAccount;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement hpsignIn;

	@FindBy(xpath = "//button[@data-action='customer-menu-toggle']")
	WebElement menuOption;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	WebElement hpsignOut;

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement hpmyAccount;

	@FindBy(xpath = "//span[contains(text(),'You are signed out')]")
	WebElement signoutConfirm;
	
	public boolean signoutFromLUMA() {

		menuOption.click();
		hpsignOut.click();
		return signoutConfirm.isDisplayed();
		
	}

	public boolean validateHomePage() {
		return homepageLogo.isDisplayed();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public LoginPage singIn() {
		hpsignIn.click();

		return new LoginPage();
	}

	public CreateAccountPage createAcc() {
		hpcreateAccount.click();

		return new CreateAccountPage();
	}

	public MyAccountPage navigatetoMyAccount() {

		menuOption.click();
		hpmyAccount.click();

		return new MyAccountPage();
	}

}
