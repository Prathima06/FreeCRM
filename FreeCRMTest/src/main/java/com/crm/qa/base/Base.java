package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	public  Base() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("E:\\Users\\bhara\\Prathima\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firfox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.get(prop.getProperty("url"));
		
	}

}
