package com.test.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.qa.base.TestBase;

public class PurchaseFlightPage extends TestBase {

	@FindBy(xpath = "//select[@name='cardType']")
	WebElement dropDownCard;

	@FindBy(xpath = "//input[@placeholder='First Last']")
	WebElement firstLastName;

	@FindBy(xpath = "//input[@placeholder='123 Main St.']")
	WebElement address;

	@FindBy(xpath = "//input[@placeholder='Anytown']")
	WebElement city;

	@FindBy(xpath = "//input[@placeholder='State']")
	WebElement state;

	@FindBy(xpath = "//input[@placeholder='12345']")
	WebElement pinCode;

	@FindBy(xpath = "//input[@placeholder='Credit Card Number']")
	WebElement creditCardNumber;

	@FindBy(xpath = "//input[@placeholder='Month']")
	WebElement month;

	@FindBy(xpath = "//input[@placeholder='Year']")
	WebElement year;

	@FindBy(xpath = "//input[@name='nameOnCard']")
	WebElement nameOnCard;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement purchaseFlightButton;

	// Initializing the Page Objects:
	public PurchaseFlightPage() {
		PageFactory.initElements(driver, this);
	}

	public ConfirmationPage SelectFieldsAndclickOnPurchaseFlight(String fandLName, String add, String town, String stat,
			String pincode, String credNumber, String mm, String yr, String cardName) {

		firstLastName.sendKeys(fandLName);
		address.sendKeys(add);
		city.sendKeys(town);
		state.sendKeys(stat);
		pinCode.sendKeys(pincode);
		creditCardNumber.sendKeys(credNumber);
		Select select3 = new Select(dropDownCard);
		select3.selectByIndex(1);
		month.sendKeys(mm);
		year.sendKeys(yr);
		nameOnCard.sendKeys(cardName);
		purchaseFlightButton.click();

		return new ConfirmationPage();
	}

}
