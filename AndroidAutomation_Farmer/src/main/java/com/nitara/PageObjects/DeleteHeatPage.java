package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DeleteHeatPage extends BasePage {

	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;

	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/breedingBtn")
	private MobileElement breeding_btn;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/ivAddActivityIcon")
	private MobileElement addActivity_Btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/heatCardView")
	private MobileElement heat_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/naturalBtn")
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/heat_date")
	private MobileElement heat_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/back_cattle_result")
	private MobileElement goBackBtn;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.Button[2]")
	private MobileElement deleteBtn ;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement popup_Yes;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/snackbar_text")
	private MobileElement deleteMsg;
	
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
	
	public void click_AddActivityBtn() {
		waitVisibility(addActivity_Btn);
		click(addActivity_Btn);
	}

	
	public void click_HeatBtn() {
		 waitVisibility(heat_btn);
		click(heat_btn);
	}
	
	public void click_HeatType() {
		waitVisibility(natural_btn);
		click(natural_btn);
	}
	
	public void enterHeatDate(String date) {
		waitVisibility(heat_date);
		clear(heat_date);
		sendKeys(heat_date, date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void click_BackBtn() {
		waitVisibility(goBackBtn);
		click(goBackBtn);
	}
	  
	   public void press_DeleteBtn() {
	    	click(deleteBtn);
	    }
	   
	   public void press_YesBtn() {
	    	waitVisibility(popup_Yes);
	    	click(popup_Yes);
	    }
	   public void assertDeleteMsg() {
		   waitVisibility(deleteMsg);
		   Assert.assertEquals(deleteMsg.getText()," Heat data recorded on 16 Nov 2021 has been deleted for this Cattle");
	   }
	
}
