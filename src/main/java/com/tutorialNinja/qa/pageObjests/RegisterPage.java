package com.tutorialNinja.qa.pageObjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
	WebDriver driver;
	    
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@	FindBy(id="input-firstname")
	private WebElement firstName1;
	
 @FindBy(id="input-lastname")
	private WebElement lastName1;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneNo;
	
	@FindBy(id="input-email")
    private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;

      @FindBy(xpath="//input[@name='agree']")
      private WebElement privacyPolicy;

     @FindBy(xpath="//input[@class='btn btn-primary']")
     private WebElement continueButton;
     
     @FindBy(xpath="//input[@name='newsletter'][@value='1']")
     private WebElement  newsleeter;
     
     @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
     private WebElement  firstNameWarning;
 
     
     @FindBy(xpath= "//input[@id='input-lastname']/following-sibling::div")
     private WebElement secondNameWarning;

     @FindBy(xpath= "//input[@id='input-email']/following-sibling::div")
     private WebElement emailWarning;
     
     @FindBy(xpath= "//input[@id='input-password']/following-sibling::div")
     private WebElement passwordWarning;
     
    

   public void enterTextInFirstNameField(String firstName) {
	   firstName1.sendKeys(firstName);
	   
	    }
    public void  enterTextInLastNameField(String lastName ) {
	   lastName1.sendKeys(lastName);
	  }
    
    public void enterTelephone(String tp) {
    	telephoneNo.sendKeys(tp);
    }
    
    public void enterEmail(String eMailField)  {
    	emailAddress.sendKeys(eMailField);
    }
    
    public void  enterPassword(String password1) {
    	password.sendKeys(password1);
    }
   
    public void enterConfirmPassword(String Cpassword1) {
    	confirmPassword.sendKeys(Cpassword1);
    }
    
    public void clickOnPrivacyPolicy() {
    	privacyPolicy.click();
    }
    
    public void clickOnContinue() {
    	continueButton.click();
    }

    public void clickonnewsleeter( ) {
    	newsleeter.click();
    }
     
    
    public boolean  firstNameWarnMsg() {
  boolean d1 = firstNameWarning.isDisplayed();
  return d1;
      }

    
    public boolean  secondNameWarnMsg() {
    	  boolean d2 = secondNameWarning.isDisplayed();
    	  return d2;
    	  
    }
 
  	  public boolean  emailNameWarnMsg() {
    			  boolean d4 = emailWarning.isDisplayed();
    			  return d4;
  	  }
 	  public boolean  passwordWarnMsg() {
    				  boolean d5 = passwordWarning.isDisplayed();
    				  return d5;
 	  
  
  	  }
   
}