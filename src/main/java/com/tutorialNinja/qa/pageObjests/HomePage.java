package com.tutorialNinja.qa.pageObjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver  driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private  WebElement  ln;
	
	@FindBy(linkText="Register")
	private WebElement registationlink;
	
	
	public HomePage(WebDriver  driver) {
		
		this.driver =driver;
		PageFactory.initElements( driver, this); 
		}
	
	
	public void clickOnmyAccount() {
		
		myAccountDropMenu.click();
	}
	
	public void clickOnLogIn() {
		 ln.click();
	}
	
	
	public void clickonRegistration() {
		registationlink.click();
	}
	
	

}
