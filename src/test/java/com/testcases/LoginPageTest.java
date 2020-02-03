package com.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hmrs.pages.LoginPage;
import com.hmrs.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods {
	// Test case to validate valid login
	@Test(groups="smoke")
	public void login() {
	
		LoginPage login = new LoginPage();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	/*
	 * Navigate to HRMS Enter uid leave password field blank click login verify
	 * "Password cannot be empty" text close browser
	 */
	@Test(groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		String expectedError = "Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		Thread.sleep(5000);
	}
	@Test(dataProvider="getData")
	public void multipleLogin(String uid, String pwd) throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, uid );
		sendText(login.password, pwd);
		Thread.sleep(3000);
		click(login.loginBtn);
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "Login");
}
}