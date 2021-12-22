/*
@Author: Neha Sahu
This test case is used to verify if User can view Insemination details of  a particular cattle.
*/
package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewInsemination_Page;
import com.nitara.utils.DataProviderUtils;

public class ViewInsemination extends GenericBase {

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_Insemination(Map<String,String> data) throws InterruptedException {
		
		Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);
		// View Insemination Page
		ViewInsemination_Page view = new ViewInsemination_Page();
		
		// Select cattle to add Insemination 
//		view.SearchCattle(data.get("CattleName"));
		view.SearchCattle("Alx");
		view.SelectCattle();
		Thread.sleep(8000);
		view.click_Breeding();
		
		Thread.sleep(8000);
		view.click_AddActivity();
		Thread.sleep(8000);
		view.click_naturalInsem_Btn();
		Thread.sleep(8000);
		view.enter_BullId(data.get("Bull_ID"));
	
		view.enterInseminationDate(data.get("Date"));
		
		 Thread.sleep(8000);
		view.press_SaveButton();
        view.click_BackBtn();
        
        // Check details of added Insemination in View Insemination Page
        Thread.sleep(8000);
	    view.findElement(data.get("Date"));
		view.checkDate(data.get("Date"));
		
		view.findElement("Natural");
		view.checkHeatType();

		view.findElement("Natural");
		view.check_InsemType();

		view.findElement(data.get("Bull_ID"));
		view.checkBullId(data.get("Bull_ID"));

		view.findElement("Recorded By : Test2");
     	view.checkRecorded();
		
	
	}
}
