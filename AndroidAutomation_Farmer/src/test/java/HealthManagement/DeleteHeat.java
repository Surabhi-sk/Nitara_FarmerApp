/*
@Author: Neha Sahu
This test case is used to verify if User can delete heat with already added heat data and check the delete message using assert.
*/
package com.nitara.DeleteActivity;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.DeleteHeatPage;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.HeatActivityView_Page;
import com.nitara.utils.DataProviderUtils;

public class DeleteHeat extends GenericBase {

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteActivity_Heat(Map<String,String> data) throws InterruptedException {
		Thread.sleep(8000);
		
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);

		// Delete Heat 
		DeleteHeatPage delete = new DeleteHeatPage();
		
		// Search cattle and add heat details
		delete.SearchCattle(data.get("CattleName"));
		delete.SelectCattle();
		Thread.sleep(8000);
		delete.click_Breeding();
		
		Thread.sleep(8000);
        delete.click_AddActivityBtn();
		Thread.sleep(8000);
		delete.click_HeatBtn();
		Thread.sleep(8000);
		delete.click_HeatType();

		delete.enterHeatDate(data.get("Date"));
		delete.press_SaveButton();
		delete.click_BackBtn();

		// Performs Delete Action
		delete.press_DeleteBtn();
		delete.press_YesBtn();
		
		//Assert Delete message
		Thread.sleep(5000);
		delete.findElement(" Heat data recorded on 16 Nov 2021 has been deleted for this Cattle");
		delete.assertDeleteMsg();
		
	}
}
