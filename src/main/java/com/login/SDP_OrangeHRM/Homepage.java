package com.login.SDP_OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public static WebDriver driver;
	
	public Homepage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div/p[text()='Username : Admin']")
	private WebElement username;
	
	@FindBy (xpath="//div/p[text()='Password : admin123']")
	private WebElement pass;
	
	@FindBy (xpath="//input[@name='username']")
	private WebElement placeholdername;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getPlaceholdername() {
		return placeholdername;
	}

	public WebElement getPlaceholderpass() {
		return placeholderpass;
	}

	public WebElement getSubmit() {
		return submit;
	}

	@FindBy (xpath="//input[@type='password']")
	private WebElement placeholderpass;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
}
