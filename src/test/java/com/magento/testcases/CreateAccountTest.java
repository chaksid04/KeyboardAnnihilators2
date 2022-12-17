package com.magento.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.magento.base.TestBase;
import com.magento.pages.CreateAccountPage;
import com.magento.pages.HomePage;
import com.magento.pages.MyAccountPage;

public class CreateAccountTest extends TestBase {

	HomePage hmpg;
	CreateAccountPage createAccPg;
	MyAccountPage myAccPage;

	public CreateAccountTest() {

		super();
	}

	@BeforeTest
	public void initialise() {

		initialization();
	}

	@BeforeMethod
	public void setUp() {

		hmpg = new HomePage();
		createAccPg = new CreateAccountPage();
		myAccPage = new MyAccountPage();
	}

	@Test(priority = 1)
	public void CreateAccountPagePresentTest() {

		hmpg.validateHomePage();
		hmpg.createAcc();
		Boolean flag = createAccPg.validateCreateAccountPage();
		Assert.assertTrue(flag);
	}

	@Test(dependsOnMethods = { "CreateAccountPagePresentTest" })
	public void ValidateCreateAccountTest() {

		myAccPage = createAccPg.enterAccountDetails(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("email"), prop.getProperty("password"));

		// Account Creation Validation
		Boolean flag = myAccPage.validateAccountCreation();
		Assert.assertTrue(flag);

		// Login Details Validation
		String loginCreds = myAccPage.getloginDetails();

		Assert.assertTrue(loginCreds.contains(prop.getProperty("firstname")));
		Assert.assertTrue(loginCreds.contains(prop.getProperty("lastname")));
		Assert.assertTrue(loginCreds.contains(prop.getProperty("email")));

		// Subscription Validation
		Boolean newsletterSubscription = myAccPage.getNewsletterSubscription();
		Assert.assertTrue(newsletterSubscription);

		// Subscription Cancellation Validation
		myAccPage.cancelSubscription();
		Boolean flagSubscription = myAccPage.validateSubscripionCancelled();
		Assert.assertTrue(flagSubscription);
	}

	@Test(dependsOnMethods = { "ValidateCreateAccountTest" })
	public void validateLogoutTest() {

		Assert.assertTrue(hmpg.signoutFromLUMA());
		Boolean flag = hmpg.validateHomePage();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void close() {

		// driver.quit();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
