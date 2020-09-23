package com.test.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.qa.base.TestBase;

public class FindFlightsPage extends TestBase {

	// Page Factory - OR:

	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement deptCity;

	@FindBy(xpath = "//select[@name='toPort']")
	WebElement destCity;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement findFlight;

	// Initializing the Page Objects:
	public FindFlightsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public ChooseFilghtPage findflight() {
		Select select1 = new Select(deptCity);
		Select select2 = new Select(destCity);
			List<WebElement> options = select2.getOptions();
			
		select2.selectByValue("Boston");
		select1.selectByIndex(2);
		findFlight.click();

		return new ChooseFilghtPage();
	}

}
