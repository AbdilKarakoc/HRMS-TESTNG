package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hmrs.pages.DashboardPageElements;
import com.hmrs.pages.LeaveListPageElements;
import com.hmrs.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LeaveListPageTest extends CommonMethods {

	@Test(groups = "regression")
	public void leaveLabelvalidation() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		jsClick(dashboard.leaveLnk);
		jsClick(dashboard.leaveList);
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
	}

	@Test(groups = "regression")
	public void leaveLabelvalidation1() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToLeaveList();
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
	}
}