package com.test.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.qa.base.TestBase;

public class ConfirmationPage extends TestBase {

	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[2]")
	WebElement confirmId;

	// Initializing the Page Objects:
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyConfirmationId() {

		return confirmId.getText();

	}

}
