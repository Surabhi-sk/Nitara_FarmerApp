/*
@Author: Neha Sahu
This test case is used to verify if User can Edit Dry Period data of a particular cattle.
*/package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.EditDryPeriod_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.utils.DataProviderUtils;

public class EditDryPeriod  extends GenericBase{
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void Edit_DryPeriod(Map<String,String> data) throws InterruptedException{
		
		Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);
		// Edit DryPeriod Page
		EditDryPeriod_Page edit = new EditDryPeriod_Page();
		
		// Select cattle to edit Dry Period
		edit.SearchCattle(data.get("CattleName"));
		edit.SelectCattle();
		edit.click_Breeding();
		
		//Click on edit button
		Thread.sleep(15000);
		edit.click_EditButton();
		
		// Enter details
		edit.enterDryPeriodDate("06 Dec 2021");
		edit.click_saveBtn();
		
		// Check the details using assert
		edit.findElement("Dry Period has been saved successfully for");
		edit.assertSuccessMsg();
		
		edit.findElement("A1");
		edit.assertCattleTag(data.get("CattleName"));
		
	}

}
