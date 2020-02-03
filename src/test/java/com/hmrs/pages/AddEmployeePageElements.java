package com.hmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {
	@FindBy(linkText = "PIM")
	public WebElement PIM;
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;
	@FindBy(name = "firstName")
	public WebElement fName;
	@FindBy(name = "middleName")
	public WebElement mName;
	@FindBy(name = "lastName")
	public WebElement lName;
	@FindBy(id = "btnSave")
	public WebElement save;
	@FindBy(xpath = "//*[@id=\"pdMainContainer\"]/div[1]/h1")
	public WebElement disp;
	public void navigateToAddEmployee() {
		click(PIM);
		click(addEmp);
		sendText(fName, "Den");
		sendText(mName, "Mel");
		sendText(lName, "Baba");
	}
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
