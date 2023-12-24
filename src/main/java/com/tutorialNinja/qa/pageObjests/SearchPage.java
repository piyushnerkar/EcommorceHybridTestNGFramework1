package com.tutorialNinja.qa.pageObjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchText;
	
	@FindBy(xpath="//div[@id='search']/descendant::button[1]")
	private WebElement searchButton;
	


public void enterProductInSearch(String search1) {
	searchText.sendKeys(search1);
	}

public void clickOnSeachButton() {
	searchButton.click();
}
	

}