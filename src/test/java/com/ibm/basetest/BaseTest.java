package com.ibm.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.magentopages.HomePage;
import com.ibm.magentopages.LoginPage;
import com.ibm.magentopages.MyAccountPage;

public class BaseTest {

	@Test
	public void LoginTest() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60); // 60 to 90

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://magento.com");

		HomePage home = new HomePage(driver);
		home.clickOnMyAccountIcon();

		LoginPage login = new LoginPage(driver, wait);
		login.enterEmailAddress("balajidinakaran1@gmail.com");
		login.enterPassword("Welcome123");
		login.clickOnLogin();

		MyAccountPage myAccount = new MyAccountPage(driver, wait);
		String actualTitle = myAccount.getCurrentTitle();

		Assert.assertEquals(actualTitle, "My Account","Title check after login");
		
		myAccount.clickOnLogOut();
	}
}
