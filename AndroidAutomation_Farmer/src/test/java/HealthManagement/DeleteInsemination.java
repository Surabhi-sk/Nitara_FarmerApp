/*
@Author: Neha Sahu
This test case is used to verify if User can delete Insemination and check the delete message using assert.
*/package com.nitara.DeleteActivity;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.DeleteInsemination_Page;
import com.nitara.PageObjects.FarmerHomePage;

import com.nitara.utils.DataProviderUtils;

public class DeleteInsemination extends GenericBase {

  @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void DeleteActivity_Insemination(Map<String,String> data) throws InterruptedException {
	  
	  Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);
		// Delete Insemination Page
		DeleteInsemination_Page delete  = new DeleteInsemination_Page();
		
		// Select cattle to add Insemination 
		delete.SearchCattle(data.get("CattleName"));
		delete.SelectCattle();
		Thread.sleep(8000);
		delete.click_Breeding();
		
		Thread.sleep(8000);
		delete.click_AddActivity();
		Thread.sleep(8000);
		delete.click_naturalInsem_Btn();
		Thread.sleep(8000);
		delete.enter_BullId(data.get("Bull_ID"));
		delete.enterInseminationDate(data.get("Date"));
		delete.press_SaveButton();
        delete.click_BackBtn();
        
         // Performs Delete Action
        delete.press_DeleteBtn();
 		delete.press_YesBtn();
 		
 		//Assert Delete message
 		Thread.sleep(5000);
 		delete.findElement(" Insemination data recorded on 20 Nov 2021 has been deleted for this Cattle");
 		delete.assertDeleteMsg();	
}
}