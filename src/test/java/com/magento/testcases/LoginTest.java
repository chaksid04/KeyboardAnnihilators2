package com.magento.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.magento.base.TestBase;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;

public class LoginTest extends TestBase {

	HomePage hmpg;
	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	@BeforeTest
	public void initialise() {

		initialization();
	}

	@BeforeMethod
	public void setUp() {

		hmpg = new HomePage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void homePagePresentTest() {

		Boolean flag = hmpg.validateHomePage();
		Assert.assertTrue(flag);
	}

	@Test(dependsOnMethods = { "homePagePresentTest" })
	public void validateLoginTest() {

		loginPage = hmpg.singIn();
		hmpg = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Boolean flag = hmpg.validateHomePage();
		Assert.assertTrue(flag);
	}

	@Test(dependsOnMethods = { "validateLoginTest" })
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
