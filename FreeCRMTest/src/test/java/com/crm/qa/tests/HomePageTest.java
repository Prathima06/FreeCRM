package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends Base{
	
	 LoginPage loginPage;
	 HomePage homePage;
	 ContactsPage contactsPage;
	 TestUtils testUtils;

	 public HomePageTest() {
		 super();
	 }
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		testUtils = new TestUtils();
		
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Homepage title is not macthed");
	}
	
	@Test(priority = 2)
	public void verifyLoginUserName() {
		testUtils.switchToFrame();
		Assert.assertTrue(homePage.verifyLoginUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsBtn() {
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
