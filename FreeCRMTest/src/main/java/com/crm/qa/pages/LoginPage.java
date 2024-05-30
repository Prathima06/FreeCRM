package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base{
	
	//Page Factory /object repository /Page objects
	@FindBy(name = "username")
	WebElement uName;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "(//img[contains(@class,\"img-responsive\")])[1]")
	WebElement crmLogo;
	
	@FindBy(xpath = "//a[conatins(text(),'Sign Up')]")
	WebElement signUp;
	
	/*
	 * we need to intitalize these web elements in constructor using page factory
	 */
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return crmLogo.isDisplayed();
		
	}
	/*
	 * After the succesful login we land at home page
	 * that is the reason the return type of login() is HomePage
	 */
	public HomePage login(String userName, String password) {
		uName.sendKeys(userName);
		pwd.sendKeys(password);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
}
