
package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.InseminatedHeiferRegister_Page;
import com.nitara.PageObjects.LoginObjects;
import com.nitara.PageObjects.MilkingCattleRegister_Page;
import com.nitara.utils.DataProviderUtils;

public class RegisterMilkingCattle extends GenericBase {

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_MilkingorDryCattle(Map<String,String> data) throws InterruptedException {

		GenerateRandomData numb = new GenerateRandomData();
		
		String eartagNumber = numb.generateRandomNumber(7);
		String cooperTagNumber = numb.generateRandomNumber(12);


		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.press_RegisterCattleButton();
	//	test.log(Status.INFO,"Register a cattle clicked");
		
		Thread.sleep(8000);
		 
		// Milking Cattle  Register form
				MilkingCattleRegister_Page reg = new MilkingCattleRegister_Page();
				reg.findElement("Milking and Dry Cattle");
				reg.assert_CattleType();
				reg.enter_TagNumber(eartagNumber);
				reg.enter_CoopTagNumber(cooperTagNumber);
				reg.select_cattleBreed(data.get("cattleType"));
				reg.select_BreedType(data.get("breed"));
				
				if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
					reg.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}
				
				reg.CurrentLactation(data.get("currentLactation"));
				
				reg.CalvingDate(data.get("lastCalvingDate"));
				
				reg.CalfResult(data.get("calfCount"));
				
				
				// Check cattle Pregnant - Artificial or Natural Insemination
				if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
					if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
						reg.isCattlePreg(data.get("pregnantSince"));
						reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
					}
					else{
						reg.isCattlePreg(data.get("pregnantSince"));
						reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
					}
				}
				

				// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
				else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
					if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
						reg.isCattleInseminated();
						reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand"),data.get("bullId"));}

					else{
						reg.isCattleInseminated();
						reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
					}
				}

				reg.press_SaveButton();
     
				Thread.sleep(10000);
				CattleRegistrationSuccess_Page msg = new CattleRegistrationSuccess_Page();
				msg.assertCattleTag(eartagNumber);
				msg.assertSuccessMsg("Registration has been saved successfully for");
				//test.log(Status.INFO,"Cattle Registered");
				
				

	}
	
}
