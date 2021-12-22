package com.nitara.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DewormingCattlePage extends BasePage {
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;

	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;


	@AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.FrameLayout[2]") 
	private MobileElement deworming_btn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.FrameLayout/android.view.View/android.widget.TextView[2]") 
	private MobileElement earTagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.view.View/android.view.View[2]/android.widget.FrameLayout[1]/android.widget.CheckBox"+ "\"))") 
	private MobileElement dewormer;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/amountValue"+ "\"))")
	private MobileElement amount;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/dateValue")
	private MobileElement date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;

	public void SearchCattle(String cattle_name) {
		waitVisibility(search_cattle);
		click(search_cattle);
		sendKeys(search_cattle,cattle_name);
	}
	
	public void SelectCattle() {
		waitVisibility(select_cattle);
		click(select_cattle);
		
	}
	
	
	public void click_dewormingBtn() {
		waitVisibility(deworming_btn);
		click(deworming_btn);
	}
	
	public void assert_earTagNumber() {
		waitVisibility(earTagNumber);
		Assert.assertEquals(earTagNumber.getText(),"pqr");
	}
	
	public void add_Dewormer() {
		waitVisibility(dewormer);
		click(dewormer);
	}
	public void enterAmount(String string) {
		waitVisibility(amount);
		sendKeys(amount,string);

	}
	

	public void enterDate(String eDate) {
		waitVisibility(date);
	
		sendKeys(date,eDate);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}

  
	
	
}
