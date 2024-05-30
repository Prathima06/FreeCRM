package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Base{
	
	LoginPage loginPage;
	HomePage homePage;
	
	/*
	 * we need to call Base class constructor as we are defining properties in Base class
	 * constructor
	 */
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest() {
		boolean crmLogo = loginPage.validateLogo();
		Assert.assertTrue(crmLogo);
	}
	
	@Test(priority = 3)
	public void loginPageTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
