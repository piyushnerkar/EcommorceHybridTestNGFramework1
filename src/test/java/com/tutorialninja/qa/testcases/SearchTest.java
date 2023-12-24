package com.tutorialninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.pageObjests.SearchPage;
import com.tutorialninja.qa.base.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	
public SearchTest() {
		
		super();
	}
	
	
	@AfterMethod
	public void  tearDown() {
	 	
		driver.quit();
	}
	//<class name="com.tutorialninja.qa.base.Base"/>
	
@BeforeMethod
	public void setUp() {
		
	driver =	 intializeBrowserAndOpenApplication(prop.getProperty("browser"));
		
	}
	@Test(priority=1)
	public void  veerifySearchWithValidProduct() {
		
		
		SearchPage search = new SearchPage(driver);
		search.enterProductInSearch(dataprop.getProperty("validProduct"));
		search.clickOnSeachButton();
		
	
 	  //   driver.findElement(By.xpath("//a[text()='Product Compare (0)']/preceding::h2"));
 	Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Product Compare (0)']/preceding::h2")).isDisplayed());
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
	
		SearchPage search = new SearchPage(driver);
		search.enterProductInSearch(dataprop.getProperty("validProduct"));
		search.clickOnSeachButton();
		Assert.fail();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following::p[1]")).isDisplayed());
	
	}
	
	@Test(priority=3, dependsOnMethods= {"verifySearchWithInvalidProduct()"})
	public void verifySearchWithNoProduct() {
		
		SearchPage search = new SearchPage(driver);
		search.enterProductInSearch(dataprop.getProperty("validProduct"));
		search.clickOnSeachButton();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following::p[1]")).isDisplayed());
		
	}

}
