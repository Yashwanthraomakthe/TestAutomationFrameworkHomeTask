package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.BaseTest;
import page.LoginPage;
import utilities.ExcelUtils;


public class LoginTest extends BaseTest {
	
	
	@Test
	public void testLogin() {
		
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(propertyReader.getUsername());
		loginPage.enterPassword(propertyReader.getPassword());
		loginPage.clickLoginButton();

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return ExcelUtils.getTestData(".\\src\\test\\resources\\Data.xlsx", "Sheet1");
	}

	@Test(dataProvider = "loginData")
	public void testLoginWithDifferentData(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	
	}
}
