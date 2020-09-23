package com.test.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.qa.util.TestUtil;
import com.test.qa.base.TestBase;
import com.test.qa.pages.ChooseFilghtPage;
import com.test.qa.pages.ConfirmationPage;
import com.test.qa.pages.FindFlightsPage;

import com.test.qa.pages.PurchaseFlightPage;

public class PurchaseFlightPageTest extends TestBase {
	FindFlightsPage findFlightPage;
	ChooseFilghtPage chooseFlightPage;
	PurchaseFlightPage purchaseFlightPage;
	ConfirmationPage confirmationPage;
	TestUtil testUtil;

	public PurchaseFlightPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		chooseFlightPage = findFlightPage.findflight();
		purchaseFlightPage = chooseFlightPage.clickOnChooseFlight();

	}

	@Parameters({ "url", "uname", "pwd" })

	@Test()
	public void testLogin(String url, String uname, String pwd) {

	}

	@Test(priority = 1)
	@Parameters({ "fname", "addr", "cty", "st", "zcode", "ccnumber", "mn", "yrs", "nocard" })
	public void PurchaseFlightandVerifyConfirmationID(String fname, String addr, String cty, String st, String zcode,
			String ccnumber, String mn, String yrs, String nocard) {

		confirmationPage = purchaseFlightPage.SelectFieldsAndclickOnPurchaseFlight(fname, addr, cty, st, zcode,
				ccnumber, mn, yrs, nocard);

		String ID = confirmationPage.verifyConfirmationId();
		Assert.assertTrue(ID.length() == 13);

	}

	/*
	 * @DataProvider(name = "testDataProvider") public Object [][] getdata(){
	 * 
	 * return new Object [][] { {},{}
	 * 
	 * };
	 * 
	 * }
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
