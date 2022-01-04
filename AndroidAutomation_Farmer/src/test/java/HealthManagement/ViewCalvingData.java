/*
@Author: Neha Sahu
This test case is used to verify if User can view  Calving data of a particular cattle.
*/
package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.ViewCalvingData_Page;
import com.nitara.utils.DataProviderUtils;

public class ViewCalvingData extends GenericBase {
        
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void ViewActivity_CalvingData(Map<String,String> data) throws InterruptedException {
		
		Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);
		// View Calving Page
		ViewCalvingData_Page view = new ViewCalvingData_Page ();
		
		// Select cattle to add Calving 
		view.SearchCattle(data.get("CattleName"));
		view.SelectCattle();
		Thread.sleep(8000);
		view.click_Breeding();  
		
		Thread.sleep(8000);
	    view.select_Lactation();
	    
	    //Check the details using assert
	    Thread.sleep(5000);
	    view.findElement("17 Dec 2021");
	    view.DateCheck("17 Dec 2021");
	    
	    view.findElement("Single");
	    view.CheckCalfResult(); 
		
		view.findElement("Male");
		view.CheckCalfResultType();
		
		view.findElement("Recorded By : Fname Rr");
		view.check_RecordedBy();
	}
}


