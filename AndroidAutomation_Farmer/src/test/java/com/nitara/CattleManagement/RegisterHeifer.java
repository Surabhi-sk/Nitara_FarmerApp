/*
@Author: Neha Sahu
This test case is used to verify if User can register Inseminated Heifer with valid data.
*/package com.nitara.CattleManagement;

import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nitara.GenericBase.GenericBase;
import com.nitara.Helper.GenerateRandomData;
import com.nitara.PageObjects.CattleRegistrationSuccess_Page;
import com.nitara.PageObjects.FarmerHomePage;
import com.nitara.PageObjects.InseminatedHeiferRegister_Page;
import com.nitara.PageObjects.LoginObjects;

import com.nitara.utils.DataProviderUtils;



public class RegisterHeifer extends GenericBase{

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void RegisterCattle_Heifer(Map<String,String> data) throws InterruptedException {

		GenerateRandomData numb = new GenerateRandomData();
	//	ExtentTest test = extent.createTest("Register Heifer Cattle", "Verify user is able to register Inseminated Heifer cattle");

	
		String tagNumber = numb.generateRandomNumber(7);
		String cooptagNumber = numb.generateRandomNumber(12);

		
		

		//Farmer Home page - Select Register Cattle
		FarmerHomePage obj = new FarmerHomePage();
		obj.press_RegisterCattleButton();
	//	test.log(Status.INFO,"Register a cattle clicked");

	   Thread.sleep(8000);

		// Inseminated Heifer Register form
		InseminatedHeiferRegister_Page reg = new InseminatedHeiferRegister_Page();
		reg.findElement("Inseminated Heifer");
		reg.assert_CattleType();
		reg.enter_TagNumber(tagNumber);
		reg.enter_CoopTagNumber(cooptagNumber);
		reg.select_YOB(data.get("yearOfBirth"));
//		reg.select_month(data.get("monthOfBirth"));
		reg.select_cattleType(data.get("cattleType"));
		reg.select_cattleBreed(data.get("breed"));

		if(data.get("isCrossBreed").equalsIgnoreCase("true")) {
			reg.select_crossbreedToggle(data.get("isCrossBreed"), data.get("crossedWith"));}

		// Check cattle Pregnant - Artificial or Natural Insemination
		if(data.get("isCattlePregnant").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				reg.isCattlePregnant(data.get("pregnantSince"));
				reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));
			}
			else{
				reg.isCattlePregnant(data.get("pregnantSince"));
				reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		// Check cattle is not pregnant and is only inseminated - Artificial or Natural Insemination
		else if(data.get("isCattleInseminated").equalsIgnoreCase("true")) {
			if(data.get("inseminationType").equalsIgnoreCase("artificial")) {
				reg.isCattleInseminated();
				reg.artificialInsemination(data.get("inseminationDate"),data.get("semenBrand") ,data.get("bullId"));}

			else{
				reg.isCattleInseminated();
				reg.naturalInsemination(data.get("inseminationDate"),data.get("bullId"));
			}
		}

		reg.press_SaveButton();

		Thread.sleep(10000);
		CattleRegistrationSuccess_Page msg = new CattleRegistrationSuccess_Page();
		msg.assertCattleTag(tagNumber);
		msg.assertSuccessMsg("Registration has been saved successfully for");
		//test.log(Status.INFO,"Cattle Registered");
		


 
	}
}