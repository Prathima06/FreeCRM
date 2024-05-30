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

public class ContactsPageTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtils testUtils;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		testUtils = new TestUtils();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1 , enabled = false)
	public void verifyContactsTitle() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void clickOnNewContactsBtn() throws InterruptedException {
//		testUtils.switchToFrame();
		homePage.clickOnNewContacts();
		contactsPage.createNewContact("Mr","Bharat","B","Unisys");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
