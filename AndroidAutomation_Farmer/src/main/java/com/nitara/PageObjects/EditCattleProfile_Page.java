package com.nitara.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditCattleProfile_Page  extends BasePage {
	
	@AndroidFindBy(id = "com.nitara.farmer:id/search_farm_param")
	private MobileElement search_cattle;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/cattle_img")
	private MobileElement select_cattle;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/editBtn")
    private MobileElement edit_Btn;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/earTagNumber_et")
	private MobileElement tagNumber;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/newCoorperativetagNumberEdtTxt")
	private MobileElement cooperTagNumber;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/add_new_cooperative_btn")
	private MobileElement addBtn;
	
	@AndroidFindBy( xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.view.View/android.widget.Spinner")
	private MobileElement month;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/breedSpinner")
	private MobileElement breed;
	
	@AndroidFindBy( id ="com.nitara.farmer:id/damEtTxt")
	private MobileElement enterDam;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/sireEtTxt")
	private MobileElement enterSire;
	
	@AndroidFindBy ( id = "com.nitara.farmer:id/updateCattleProfileBtn")
	private MobileElement saveBtn;
	
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
	
	public void click_editBtn() {
		click(edit_Btn);
	}
	public void editTagNumber(String tgNumb) {
		waitVisibility(tagNumber);
		clear(tagNumber);
		sendKeys(tagNumber, tgNumb);
	}
	
	public void enterCooperTagNumber(String cNumber) {
		waitVisibility(cooperTagNumber);
		sendKeys(cooperTagNumber, cNumber);
		click(addBtn);
	}
	
	public void selectMonth (String monthOfBrth) {
//		waitVisibility(month);
		click(month);
		select_dropdown(monthOfBrth);
	}
	 public void select_Breed(String breedd) {
//		 waitVisibility(breed);
		 click(breed);
		 select_dropdown(breedd);
	 }
	 public void enter_Dam(String dmTxt) {
		 waitVisibility(enterDam);
		 sendKeys(enterDam, dmTxt);
		 hideKeyboard();
	 }
	 public void enter_Sire(String sireTxt) {
		 waitVisibility(enterSire);
		 sendKeys(enterSire, sireTxt);
		 hideKeyboard();
	 }
	  public void clickSave() {
		  click(saveBtn);
	  }
}
