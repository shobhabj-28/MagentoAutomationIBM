package com.ibm.magentopages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy(id="email")
	WebElement emailEle;
	
	@FindBy(how=How.ID,using="pass")
	WebElement passEle;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginEle;
	
	By errorMsgLoc =By.className("error-msg");
	

	WebDriverWait wait;
	WebDriver driver;
	
	public LoginPage(WebDriver driver,WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}

	public void enterEmailAddress(String userName)
	{
		emailEle.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passEle.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		loginEle.click();
	}
	
	public String getPageSourceForInvalidErrorMessage()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(errorMsgLoc));
		
		return driver.getPageSource();
	}
}
