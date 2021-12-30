package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HeatActivityView_Page extends BasePage {

	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;

	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/breedingBtn")
	private MobileElement breeding_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/ivAddActivityIcon")
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
	
	@AndroidFindBy(id = "com.nitara.farmer:id/l2value")
	private MobileElement breedingStatus;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/tvDateLeft")
	private MobileElement checkDate;
	
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]")
	private MobileElement heatTyData;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.TextView[2]")
	private MobileElement recordedData;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/tvTotalDaysLeft"+ "\"))")
	private MobileElement totalDaysLeft;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.Button[2]")
	private MobileElement deleteBtn ;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement popup;
	
	
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
	
	public void click_AddActivity() {
		waitVisibility(addActivity_Btn);
		click(addActivity_Btn);
	}
	
	public void click_HeatBtn() {
		waitVisibility(heat_btn);;
		click(heat_btn);
	}
	
	public void click_HeatType() {
		waitForVisibility(natural_btn);
		click(natural_btn);
	}
	
	public void enterHeatDate(String date) {
		waitForVisibility(heat_date);
		clear(heat_date);
		sendKeys(heat_date, date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void click_BackBtn() {
		waitForVisibility(goBackBtn);
		click(goBackBtn);
	}
    public void check_breedingStatus() {
    	waitVisibility(breedingStatus);
    	Assert.assertEquals(breedingStatus.getText(),"Open");
    }
    
    public void checkDate(String cdate) {
    	waitVisibility(checkDate);
    	Assert.assertEquals(checkDate.getText(),cdate);
    }
	
    public void check_HeatType() {
    	waitVisibility(heatTyData);
    	Assert.assertEquals(heatTyData.getText(),"Natural");
    }
    
    public void check_RecordedData() {
    	waitVisibility(recordedData);
    	Assert.assertEquals(recordedData.getText(),"Recorded By : Test2");
    }
    
    public void check_TotalDays() {
    	waitVisibility(totalDaysLeft);
    	Assert.assertEquals(totalDaysLeft.getText(),"Days 55");
    }
    
 
    
    
 
}
