package com.tutorialninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.Utils.Utilities;
import com.tutorialNinja.qa.pageObjests.HomePage;
import com.tutorialNinja.qa.pageObjests.RegisterPage;
import com.tutorialninja.qa.base.Base;

public class RegisterTest  extends Base{
	public WebDriver  driver;
	public RegisterTest() {
		
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp() {
		
		driver =	intializeBrowserAndOpenApplication(prop.getProperty("browser"));
		}
	
	@AfterMethod
	public void  tearDown() {
	 	
		driver.quit();
	}
	

	
	
	@Test(priority=1) 
	public void verifyRegistrationWithOnlyWithMandetoryFields() {
		
		HomePage homePage  =new HomePage(driver);
		homePage.clickOnmyAccount();
		homePage.clickonRegistration();
		RegisterPage rp = new RegisterPage(driver);
		rp.enterTextInFirstNameField(dataprop.getProperty("firstName1"));
		rp.enterTextInLastNameField(dataprop.getProperty("lastname1"));
		rp.enterTelephone(dataprop.getProperty("telephone1"));
		rp.enterEmail(Utilities.genrateEmailTimeStamp());
		rp.enterPassword(prop.getProperty("validPassword3inReg"));
		rp.enterConfirmPassword(prop.getProperty("validPassword3inReg"));
		rp.clickOnPrivacyPolicy();
		rp.clickOnContinue();
		String  actuaElementl = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actuaElementl, "Your Account Has Been Created!","Account Success Page is not displayed"); 		
	}
	@Test(priority=2)
	public void verifyRegistrationWithAllWithMandetoryFields() {
		
		HomePage homePage  =new HomePage(driver);
		homePage.clickOnmyAccount();
		homePage.clickonRegistration();
		RegisterPage rp = new RegisterPage(driver);
		rp.enterTextInFirstNameField(dataprop.getProperty("firstName1"));
		rp.enterTextInLastNameField(dataprop.getProperty("lastname1"));
		rp.enterTelephone(dataprop.getProperty("telephone2"));
		rp.enterEmail(Utilities.genrateEmailTimeStamp());
		rp.enterPassword(prop.getProperty("validPssword2InReg"));
		rp.enterConfirmPassword(prop.getProperty("validPssword2InReg"));
		rp.clickOnPrivacyPolicy();
		rp.clickonnewsleeter();
		rp.clickOnContinue();
		
	
String  actuaElementl = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
String expectedText="Your Account Has Been Created!";
Assert.assertEquals(actuaElementl, expectedText,"Account Success Page is not displayed");
	}
	@Test(priority=3)
	public void   verifyRegistrationWithOnlyWithSameFields() {
		
		
		HomePage homePage  =new HomePage(driver);
		homePage.clickOnmyAccount();
		homePage.clickonRegistration();
		RegisterPage rp = new RegisterPage(driver);
		rp.enterTextInFirstNameField(dataprop.getProperty("firstName2"));
		rp.enterTextInLastNameField(dataprop.getProperty("lastname2"));
		rp.enterTelephone(dataprop.getProperty("telephone1"));
		rp.enterEmail(prop.getProperty("validEmailInReg"));
		rp.enterPassword(prop.getProperty("validPsswordInReg"));
		rp.enterConfirmPassword(prop.getProperty("validPsswordInReg"));
		rp.clickOnPrivacyPolicy();
		rp.clickonnewsleeter();
		rp.clickOnContinue();
		

		String  actuaElementl = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
String actText = driver.findElement(By.xpath("//i[@class='fa fa-exclamation-circle']/ancestor::div[1]")).getText();
Assert.assertEquals(actText, "Warning: E-Mail Address is already registered!");
		
	}
	
	@Test(priority=4)
	public void verifyRegistrationWithOnlyWithEmptyFields() {
		
		HomePage homePage  =new HomePage(driver);
		homePage.clickOnmyAccount();
		homePage.clickonRegistration();
		RegisterPage rp = new RegisterPage(driver);
		rp.clickOnPrivacyPolicy();
		rp.clickonnewsleeter();
		rp.clickOnContinue();
	//	Assert.assertTrue(rp.firstNameWarnMsg()).isDisplayed();
		rp.firstNameWarnMsg();
		rp.secondNameWarnMsg();
		rp.emailNameWarnMsg();
		rp.passwordWarnMsg();
		
		
	
		
		

  /*    String act = (driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText());
         
     //    Assert.assertEquals(act, "Warning: You must agree to the Privacy Policy!");
/
*/
	}
	
	
	

}
