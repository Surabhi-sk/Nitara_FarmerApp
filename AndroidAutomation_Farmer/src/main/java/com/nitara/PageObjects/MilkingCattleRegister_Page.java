package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MilkingCattleRegister_Page extends BasePage{
	
	@AndroidFindBy(id = "com.nitara.farmer:id/select_cattle_tv") 
	private MobileElement select_cattle;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/earTagNumberOrName")
	private MobileElement earTagNumber;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/cooperative_tag_number_et")
	private MobileElement cooperTagNumber;
	
	@AndroidFindBy(id = "android:id/text1")
	private MobileElement breedDropdown;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/select_group_container")
	private MobileElement breedTypeDropdown;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/crossbreed_toogle")
	private MobileElement crossBreedToggle;
	

 	@AndroidFindBy(id = "com.nitara.farmer:id/crossed_with_list_spinner") 
 	private MobileElement crossed_with;
 	
 	@AndroidFindBy(id = "com.nitara.farmer:id/current_lactation_container")
	private MobileElement lactationButton;
	
 	@AndroidFindBy(id = "com.nitara.farmer:id/calvingDate")
	private MobileElement calvingDate;
 	
 	@AndroidFindBy(id = "com.nitara.farmer:id/calf_result_container")
	private MobileElement calfResult;
 	
 	@AndroidFindBy(id = "com.nitara.farmer:id/calf_result1_container")
	private MobileElement calfResultType;
 	
 	@AndroidFindBy(id = "com.nitara.farmer:id/is_pregnant")
	private MobileElement isPregnant;
 	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/pregnant_since_container") 
	private MobileElement pregnant_since;
	
	
	@AndroidFindBy(id = "com.nitara.farmer:id/inserminationDate") 
	private MobileElement inserminationDate; 
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/insemination_type_spinner"+ "\"))")  
	private MobileElement insemination_type; //change
	
	@AndroidFindBy(id = "com.nitara.farmer:id/semen_brand_spinner") 
	private MobileElement semen_brand;     
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/bull_id_et"+ "\"))") 
	private MobileElement bull_id;   //change
	

	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			 + "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/is_Incerminated"+ "\"))")
	private MobileElement isInseminated;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			+ "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/insemination_date_lbl"+ "\"))") 
	private MobileElement insemination_date_lbl;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			 + "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/is_cattle_dry"+ "\"))")
	private MobileElement isCattleDry;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/inserminationDate") 
	private MobileElement dryPeriodDate;  // change
	
	 @AndroidFindBy(uiAutomator = "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
			 + "new UiSelector().resourceIdMatches(\"" +"com.nitara.farmer:id/save_btn"+ "\"))")
     private MobileElement save_btn;
	
	
	public void assert_CattleType() {
		waitVisibility(select_cattle);
		Assert.assertEquals(select_cattle.getText(),"Milking and Dry Cattle");	
	}
	
	public void enter_TagNumber(String tag) {
		waitVisibility( earTagNumber);
		sendKeys( earTagNumber,tag);
	}
	
	public void enter_CoopTagNumber(String tag) {
		waitVisibility(cooperTagNumber);
		sendKeys(cooperTagNumber,tag);
	}
	
     public void select_cattleBreed(String breed) {
			click(breedDropdown);
			select_dropdown(breed);
		}
	
     public void select_BreedType(String breedType) {
			click(breedTypeDropdown);
			select_dropdown(breedType);
		}
	
     public void select_crossbreedToggle(String toggle,String crossbreed) {
 		//scrollfindElement("CROSSBREED");
 		String checked = crossBreedToggle.getAttribute("checked");
 		if(checked.equals("false") && toggle.equals("true")) {
 			crossBreedToggle.click(); 
 			click(crossed_with);
 			select_dropdown(crossbreed);
 		}
 	}
     
     public void CurrentLactation(String lactation) {
    		click(lactationButton);
		select_dropdown(lactation);
 		  
 	}
     public void CalvingDate(String date) {
 		sendKeys(calvingDate,date);
 	}
     
     
     public void CalfResult(String calf) {
 		click(calfResult);
 		select_dropdown(calf);
 	}
 	
 	public void CalfResultType(String calfType) {
 		click(calfResultType);
 		select_dropdown(calfType);
 	}
 	
 	public void isCattlePreg(String months) {
		String checked = isPregnant.getAttribute("checked");
		if(checked.equals("false")) {
			isPregnant.click();	
			pregnant_Since(months);
		}
	}
	
	public void isCattleInseminated() {
		String checked = isInseminated.getAttribute("checked");
		if(checked.equals("false")) {
			isInseminated.click();	
		}
	}
	
	public void artificialInsemination(String date,String semen,String BullId) throws InterruptedException {
		enter_InseminationDate(date);
		select_semenBrand(semen);
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	
	public void naturalInsemination(String date,String BullId) {
		enter_InseminationDate(date);
		click(insemination_type);
		select_dropdown("Natural");
		enter_BullId(BullId);
		hideKeyboard();
	}
	
	

	public void pregnant_Since(String months) {
		click(pregnant_since);
		select_dropdown(months+" Month");
	}
	
	public void enter_InseminationDate(String Date) {
		sendKeys(inserminationDate,Date);
	}
	
	public void select_semenBrand(String semen) {
		click(semen_brand);
		select_dropdown(semen);
	}
	
	
	public void enter_BullId(String bullId) {
		sendKeys(bull_id,bullId);
	}
	
	public void press_SaveButton() {
		click(save_btn);	
	}





	
}
