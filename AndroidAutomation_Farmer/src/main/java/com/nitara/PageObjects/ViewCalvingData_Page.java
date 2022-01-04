package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ViewCalvingData_Page  extends BasePage{

	@AndroidFindBy( id = "com.nitara.farmer:id/search_farm_param")
	private MobileElement searchCattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/breedingBtn")
	private MobileElement breeding_btn;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"17 Dec 2021\"))")
	private MobileElement element;
	
	@AndroidFindBy( xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Spinner")
	private MobileElement selectLactation;
	
	@AndroidFindBy( id = "android:id/text1")
	private MobileElement count;
//	
//	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true))" +
//	         ".scrollIntoView(new UiSelector().text(\"Single \"))")
//	private MobileElement check_calfResult;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[3]/android.widget.TextView[1]")
	private MobileElement check_calfResult;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[3]/android.widget.TextView[2]")
	private MobileElement check_calfResultType;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[3]/android.widget.TextView[3]")
	private MobileElement recordedBy;
	
	public void SearchCattle(String cattle_name) {
		waitVisibility(searchCattle);
	    click(searchCattle);
	    sendKeys(searchCattle, cattle_name);
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
	
	public void select_Lactation() {
		click(selectLactation);
		waitVisibility(count);
		click(count);
		
	}
	
	public void DateCheck( String date) {
		waitVisibility(element);
		Assert.assertEquals(element.getText(), date);
		
	}
	
	public void CheckCalfResult() {
		waitVisibility(check_calfResult);
		Assert.assertEquals(check_calfResult.getText(), "Single");
	}
	
	public void CheckCalfResultType() {
		waitVisibility(check_calfResultType);
		Assert.assertEquals(check_calfResultType.getText(), "Male");
	}
	
	public void check_RecordedBy() {
		waitVisibility(recordedBy);
		Assert.assertEquals(recordedBy.getText(), "Recorded By : Fname Rr");
	}
}
