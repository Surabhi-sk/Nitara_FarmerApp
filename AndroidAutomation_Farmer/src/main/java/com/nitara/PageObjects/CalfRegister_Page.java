package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalfRegister_Page extends BasePage {

	@AndroidFindBy(id = "com.nitara.farmer:id/select_cattle_tv") 
	private MobileElement select_cattle;

	@AndroidFindBy(id = "com.nitara.farmer:id/earTagNumberOrName") 
	private MobileElement TagNumber;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cooperative_tag_number_et") 
	private MobileElement CoopTagNumber;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/year_of_birth_spinner"+ "\"))") 
	private MobileElement year_of_birth;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/month_of_birth_spinner") 
	private MobileElement month;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/crossed_with_list_spinner") 
	private MobileElement crossed_with;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cattle_type_spinner") 
	private MobileElement cattle_type;
	
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/breed_list_spinner"+ "\"))")  
	private MobileElement breed_list;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/crossbreed_lbl") 
	private MobileElement crossbreed_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/crossbreed_toogle"+ "\"))") 
	private MobileElement crossbreed_toogle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/gender_calf_spinner") 
	private MobileElement calfGender;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/weight"+ "\"))")  
	private MobileElement weight1;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/save_btn"+ "\"))")  
	private MobileElement save_btn;
	
	
	public void assert_CattleType() {
		waitVisibility(select_cattle);
		Assert.assertEquals(select_cattle.getText(), "Calf");
	}

	public void enter_TagNumber(String tag) {
		waitVisibility(TagNumber);
		sendKeys(TagNumber,tag);
	}
	
	public void enter_CoopTagNumber(String tag) {
		waitVisibility(CoopTagNumber);
		sendKeys(CoopTagNumber,tag);
	}
	

	public void select_YOB(String year) {
		click(year_of_birth);
		select_dropdown(year);

	}
	
	public void select_month(String mnth) {
		click(month);
		select_dropdown(mnth);

	}
	
	public void select_cattleType(String type) {
		click(cattle_type);
		select_dropdown(type);
	}
	
	public void select_cattleBreed(String breed) {
		scrollfindElement("BREED");
		click(breed_list);
		select_dropdown(breed);
	}
	
	public void select_crossbreedToggle(String toggle,String crossbreed) {
		//scrollfindElement("CROSSBREED");
		String checked = crossbreed_toogle.getAttribute("checked");
		if(checked.equals("false") && toggle.equals("true")) {
			crossbreed_toogle.click(); 
			click(crossed_with);
			select_dropdown(crossbreed);
		}
	
	}
	
	public void calf_Gender( String Gender) {
		click(calfGender);
		select_dropdown(Gender);
	}
	
	 public void enter_Weight( String wgt) {
		 click(weight1);
		 sendKeys(weight1, wgt);
		 hideKeyboard();
	 }
	public void press_SaveButton() {
		click(save_btn);	
	}
}
