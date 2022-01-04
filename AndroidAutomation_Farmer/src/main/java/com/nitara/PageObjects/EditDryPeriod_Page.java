package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditDryPeriod_Page extends BasePage{
	@AndroidFindBy( id = "com.nitara.farmer:id/search_farm_param")
	private MobileElement search_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/breedingBtn")
	private MobileElement breeding_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/btnEditRight")
	private MobileElement editBtn;
	
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.EditText")
	private MobileElement enterDate;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement saveBtn;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/successMessage")
	private MobileElement successMsg;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/cattleTags")
	private MobileElement cattleTag;
	
	public void SearchCattle(String cattle_name) {
		waitVisibility(search_cattle);
	    click(search_cattle);
	    sendKeys(search_cattle, cattle_name);
		hideKeyboard();
	}
	public void SelectCattle() {
		waitVisibility(select_cattle);
		click(select_cattle);
		
	}
	
	public void click_Breeding() {
		waitVisibility(breeding_btn);
		click(breeding_btn);
	}

	public void click_EditButton() {
		waitVisibility(editBtn);
		click(editBtn);
	}
	
	public void enterDryPeriodDate(String eDate) {
		waitVisibility(enterDate);
		clear(enterDate);
		sendKeys(enterDate, eDate);
	}
	
	public void click_saveBtn() {
		click(saveBtn);
	}
	
	public void assertSuccessMsg() {
		waitVisibility(successMsg);
		Assert.assertEquals(successMsg.getText(),"Dry Period has been saved successfully for");
	}
	
	public void assertCattleTag( String tag) {
		waitVisibility(cattleTag);
		Assert.assertEquals(cattleTag.getText(),tag);
	}
}
