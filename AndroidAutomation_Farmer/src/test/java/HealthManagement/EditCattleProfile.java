/*
@Author: Neha Sahu
This test case is used to verify if User can edit Cattle Profile data of a particular cattle.
*/
package HealthManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.EditCattleProfile_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.utils.DataProviderUtils;

public class EditCattleProfile  extends GenericBase {
        
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void EditActivity_CattleProfile(Map<String,String> data) throws InterruptedException{
		
	GenerateRandomData numb = new GenerateRandomData();
		
		
		String cooperTagNumber = numb.generateRandomNumber(12);

		Thread.sleep(8000);
		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.clickSearchBtn();
		
		Thread.sleep(8000);
		EditCattleProfile_Page edit = new EditCattleProfile_Page();
		
		// Select cattle to edit details
		edit.SearchCattle(data.get("cattleType"));
		edit.SelectCattle();
	    Thread.sleep(5000);
		edit.click_editBtn();
		
		// Enter details to edit cattle profile
		Thread.sleep(8000);
		edit.editTagNumber(data.get("TagNumber"));
		edit.enterCooperTagNumber(cooperTagNumber);
		edit.selectMonth("JANUARY");
		edit.select_Breed(data.get("breed"));
		edit.enter_Dam(data.get("Dam"));
		edit.enter_Sire(data.get("sire"));
		edit.clickSave();
	}
}
