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

public class HomePageTest extends TestBase {

	HomePage hmpg;
	CreateAccountPage createAccPg;

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void initialise() {

		initialization();
	}

	@BeforeMethod
	public void setUp() {

		hmpg = new HomePage();

	}

	@Test(priority = 1)
	public void HomePagePresentTest() {

		Boolean flag = hmpg.validateHomePage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void HomePageTitleTest() {

		String hmpageTitle = hmpg.validateHomePageTitle();
		Assert.assertEquals(hmpageTitle, prop.get("homepagetitle"));
	}

	@Test(priority = 3)
	public void CreateAccountTest() {

		createAccPg = hmpg.createAcc();
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
