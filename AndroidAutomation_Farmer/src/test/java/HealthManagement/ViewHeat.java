/*
@Author: Neha Sahu
This test case is used to verify if User can view Heat details of a particular cattle.
*/
package com.nitara.ViewActivity;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.HeatActivityView_Page;
import com.nitara.utils.DataProviderUtils;

public class ViewHeat extends GenericBase  {
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewHeatData_Milking(Map<String,String> data) throws InterruptedException {
		
		Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);
		
		// View Heat Page
		HeatActivityView_Page view = new HeatActivityView_Page();
	
		//Search cattle to view heat data
		view.SearchCattle("alpha");
		view.SelectCattle();
		Thread.sleep(8000);
		view.click_Breeding();
		
		Thread.sleep(8000);
		view.click_AddActivity();
		view.click_HeatBtn();
		Thread.sleep(8000);
		view.click_HeatType();
		view.enterHeatDate(data.get("Date"));
		view.press_SaveButton();
		view.click_BackBtn();

		// Check details of added Heat in View Heat Page using Assert
		Thread.sleep(8000);
		view.findElement("Open");
		view.check_breedingStatus();
	    view.findElement(data.get("Date"));
		view.checkDate(data.get("Date"));
		
		view.findElement("Natural");
		view.check_HeatType();
		
		view.findElement("Recorded By : Test2");
		view.check_RecordedData();
		
		Thread.sleep(8000);
		view.findElement("Days 55");
		view.check_TotalDays();
		


}
}
