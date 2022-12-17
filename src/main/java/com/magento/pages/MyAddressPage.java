package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.base.TestBase;

public class MyAddressPage extends TestBase{
	
	public MyAddressPage() {

		PageFactory.initElements(driver, this);

	}

	


	@FindBy(xpath = "//span[contains(text(),'Add New Address')]")
	WebElement addressPage;

	@FindBy(name = "firstname")
	WebElement addressFirstName;
	
	@FindBy(name = "lastname")
	WebElement addressLastName;
	
	@FindBy(name = "company")
	WebElement addressCompany;
	
	@FindBy(name = "telephone")
	WebElement addressTelephone;
	
	@FindBy(id = "street_1")
	WebElement addressStreet1;
	
	@FindBy(id = "street_2")
	WebElement addressStreet2;
	
	@FindBy(id = "street_3")
	WebElement addressStreet3;
	
	@FindBy(name = "city")
	WebElement addressCity;
	
	@FindBy(name = "region_id")
	WebElement addressState;
	
	@FindBy(name = "postcode")
	WebElement addressPostCode;
	
	@FindBy(name = "country_id")
	WebElement addressCountry;
	
	@FindBy(xpath = "//span[contains(text(),'Save Address')]")
	WebElement addressSave;
	
	
	
	

	@FindBy(xpath = "//button[@name='send']")
	WebElement signIn;

	@FindBy(xpath = "(//a[@href='https://magento.softwaretestingboard.com/customer/account/create/'])[3]")
	WebElement createAccount;

	@FindBy(name = "email")
	WebElement subscribe;

//	public String validateLoginPageTitle() {
//
//		return driver.getTitle();
//	}
//
//	public boolean validateLoginPage() {
//
//		return customerLogin.isDisplayed();
//	}
//
//	public CreateAccountPage createAccount() {
//		createAccount.click();
//
//		return new CreateAccountPage();
//
//	}
//
//	public HomePage login(String un, String pwd) {
//		username.sendKeys(un);
//		password.sendKeys(pwd);
//		signIn.click();
//
//		return new HomePage();
//
//	}
	
	

}
