package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Base;

public class ContactsPage extends Base{
	
	//Page objects or web elements
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//input[contains(@value,'New Contact')]")
	WebElement newContactBtn;
	
	@FindBy(name = "title")
	WebElement titleDropDown;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(xpath = "(//input[@type='submit' and @value='Save'])[2]")
	WebElement saveBtn;
	
	/*
	 * Intializing page objects
	 */
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Actions
	 */
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void createNewContact(String title,String fName,String lName,String compName) {
		Select sel = new Select(titleDropDown);
		sel.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		companyName.sendKeys(compName);
		saveBtn.click();
		
	}
}
