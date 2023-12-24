package com.tutorialninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialNinja.Utils.Utilities;
import com.tutorialNinja.qa.pageObjests.HomePage;
import com.tutorialNinja.qa.pageObjests.logInPage;
import com.tutorialninja.qa.base.Base;

public class LoginTest extends Base {
	
	public LoginTest() {
		
		super();
	}
	
public 	WebDriver driver;
	logInPage logIn;
	HomePage homePage;
	@BeforeMethod
	public void setUp() {
		
		driver = intializeBrowserAndOpenApplication( prop.getProperty("browser"));
		

        homePage = new HomePage(driver);
		homePage.clickOnmyAccount();
		homePage.clickOnLogIn();
	      
	}
	@AfterMethod
	public void  tearDown() {
	 	
		driver.quit();
	}
	
	@Test(priority=1)
	public void logInWithValidCreedentials() {
		
	
		
	    logIn = new  logInPage(driver);
		logIn.eM(prop.getProperty("validEmail"));
		logIn.pw(prop.getProperty("validPasswoord"));
		logIn.lnButton();

		
     
       
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
		}
	
	
		
		
	@Test(priority=2)
	public void verifyLogInWithInvalidCredentials() {
		 logIn = new  logInPage(driver);
		logIn.eM(Utilities.genrateEmailTimeStamp());
		logIn.pw(prop.getProperty("validPasswoord"));
		logIn.lnButton();
		
	
	//	driver.findElement(By.id("input-email")).sendKeys(Utilities.genrateEmailTimeStamp());
	
	Assert.assertTrue(	driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	}
	@Test(priority=3)
	public void logInWithNoCredentials() {
		logIn = new  logInPage(driver);
		logIn.lnButton();
		
	Assert.assertTrue(	driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	}

	
}
	
		
		
	
	


