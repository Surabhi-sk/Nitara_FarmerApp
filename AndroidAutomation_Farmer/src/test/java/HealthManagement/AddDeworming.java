/*
@Author: Neha Sahu
This test case is used to verify if User can add DEWORMING data in a particular cattle.
*/
package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.BullRegister_Page;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.DewormingCattlePage;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.utils.DataProviderUtils;

public class AddDeworming extends GenericBase {

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void AddDeworming_Cattle(Map<String,String> data) throws InterruptedException {

		  Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.press_HealthManagementButton();
         Thread.sleep(8000);

		// Add deworming page
		DewormingCattlePage add = new DewormingCattlePage();
		
//		add.SearchCattle(data.get("CattleName"));
		add.SearchCattle("Milking1");
		add.SelectCattle();

		  Thread.sleep(8000);
		add.click_dewormingBtn();

        add.select_dewormer("Felbendazole");

	    add.enterAmount("400");
		add.enterDate(data.get("Date"));




	}
}
