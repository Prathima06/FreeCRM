package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Base;

public class TestUtils extends Base{
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public String[][] getdata() {
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			fis = new FileInputStream("E:\\Users\\bhara\\Prathima\\FreeCRMTest\\src\\"
					+ "main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int noOfRows = wb.getSheet("Contacts").getPhysicalNumberOfRows();
		int noOfCol = wb.getSheet("COntacts").getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[noOfRows - 1][noOfCol];
		int k=0;
		for(int i=0;i< noOfRows;i++) {
			for(int j=0;j<noOfCol;j++) {
				data[k][j] = wb.getSheet("Sheet1").getRow(i).getCell(j).toString();
			}
			k++;
			
		}
		return data;
	}
	
	/*
	 * Drop Down
	 */
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public  void doSelectByValue(By locator,String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByValue(value);
		
	}
	
	public  void doSelectByVisibleText(By locator,String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(value);
		
	}
	
	public  void doSelectByIndex(By locator,int index) {
		Select sel= new Select(getElement(locator));
		sel.selectByIndex(index);
		
	}
	
	public void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
		element.click();
		
	}
	
	
	
}
