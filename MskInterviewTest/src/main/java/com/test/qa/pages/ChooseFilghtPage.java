package com.test.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;

public class ChooseFilghtPage extends TestBase {

	@FindBy(xpath = "//form[@name='VA43']//following::input[@type='submit'][2]")
	WebElement chooseFlight;

	// Initializing the Page Objects:
	public ChooseFilghtPage() {
		PageFactory.initElements(driver, this);
	}

	public PurchaseFlightPage clickOnChooseFlight() {

		chooseFlight.click();

		return new PurchaseFlightPage();
	}

}
