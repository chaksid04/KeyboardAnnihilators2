package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "login[username]")
	WebElement username;

	@FindBy(xpath = "//span[contains(text(),'Customer Login')]")
	WebElement customerLogin;

	@FindBy(name = "login[password]")
	WebElement password;

	@FindBy(xpath = "//button[@name='send']")
	WebElement signIn;

	@FindBy(xpath = "(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[3]")
	WebElement createAccount;

	@FindBy(name = "email")
	WebElement subscribe;

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean validateLoginPage() {

		return customerLogin.isDisplayed();
	}

	public CreateAccountPage createAccount() {
		createAccount.click();

		return new CreateAccountPage();

	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signIn.click();

		return new HomePage();

	}

}
