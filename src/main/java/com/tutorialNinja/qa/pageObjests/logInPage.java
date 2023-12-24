package com.tutorialNinja.qa.pageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logInPage {
	
	WebDriver  driver;
	
	public logInPage(WebDriver  driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
			}
	
	
	@FindBy(id="input-email")
	private WebElement eMailAddress;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;                                  
	
	public void eM(String email) {
		eMailAddress.sendKeys(email);
		
	}
	
	public void pw(String password) {
		passwordField.sendKeys(password);
	}
	
	public void lnButton() {
		loginButton.click();
	}
	
	
	

}
