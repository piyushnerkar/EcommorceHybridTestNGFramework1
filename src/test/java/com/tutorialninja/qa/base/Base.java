package com.tutorialninja.qa.base;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tutorialNinja.Utils.Utilities;

public class Base {
	  
	WebDriver driver;
	
public Properties prop;
public Properties dataprop;

	
		
		public Base() {
			
			prop=	new Properties();
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
	     dataprop = new Properties();
		File propFile1 = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialninja\\qa\\testdata\\testdata.properties");
		
		try {
		FileInputStream fis1 = new FileInputStream(propFile1);
		dataprop.load(fis1);
		}catch(Throwable e)  {
			e.printStackTrace();
		}
		
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);   
		} catch(Throwable e) {
		e.printStackTrace();
		}
	}
	
		@Test
	public WebDriver intializeBrowserAndOpenApplication(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver =new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver =new FirefoxDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
			driver =new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		

	}

}
