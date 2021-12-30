package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ViewInsemination_Page extends BasePage {

	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param") 
	private MobileElement search_cattle;

	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_img") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/breedingBtn")
	private MobileElement breeding_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/btnAddActivity")
	private MobileElement addActivity_Btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/natural_insemination")
	private MobileElement natural_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/bullId")
	private MobileElement bullId;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/insemination_date")
	private MobileElement insemination_date;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/saveBtn"+ "\"))")  
	private MobileElement save_btn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/back_cattle_result")
	private MobileElement goBackBtn;
	
	@AndroidFindBy(id ="com.nitara.farmer:id/tvDateLeft")
	private MobileElement checkDate;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]")
	private MobileElement heatType;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[1]")
	private MobileElement insem_Type;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[3]")
	private MobileElement recordedBy;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.TextView[2]")
	private MobileElement checkId;
	
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
	
	public void click_naturalInsem_Btn() {
		waitVisibility(natural_btn);
		click(natural_btn);
	}
	
	public void enter_BullId(String bId) {
		waitVisibility(bullId);
		click(bullId);
		sendKeys(bullId, bId);
		hideKeyboard();
	}
	
	public void enterInseminationDate(String date) {
		waitVisibility(insemination_date);
		clear(insemination_date);
		sendKeys(insemination_date, date);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}
	
	public void click_BackBtn() {
		waitVisibility(goBackBtn);
		click(goBackBtn);
	}
	
	 public void checkDate(String cdate) {
	    	waitVisibility(checkDate);
	    	Assert.assertEquals(checkDate.getText(),cdate);
	    }
	
	public void checkHeatType() {
		waitVisibility(heatType);
		Assert.assertEquals(heatType.getText(),"Natural");
	}
	public void check_InsemType() {
		waitVisibility(insem_Type);
		Assert.assertEquals(insem_Type.getText(),"Natural");
	}
	
	public void checkRecorded() {
		waitVisibility(recordedBy);
		Assert.assertEquals(recordedBy.getText(),"Recorded By : Test2");
	}
	public void checkBullId(String cId) {
		waitVisibility(checkId);
		Assert.assertEquals(checkId.getText(),cId);
	}
}
