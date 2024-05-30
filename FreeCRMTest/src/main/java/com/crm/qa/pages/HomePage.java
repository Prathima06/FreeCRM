package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.Base;

public class HomePage extends Base{
	
	@FindBy(xpath = "//td[contains(text(),'User: Gagan Khanna')]")
	WebElement loginUserName;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksBtn;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContact;
	
	/*
	 * Initialize the page objects
	 */
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Actions or methods
	 */
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyLoginUserName() {
		return loginUserName.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsBtn.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsBtn.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		dealsBtn.click();
		return new TasksPage();
	}
	
	public void clickOnNewContacts() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(contactsBtn).build().perform();
		newContact.click();
//		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(newContact)).click(); 
	}
	
	
	
}
