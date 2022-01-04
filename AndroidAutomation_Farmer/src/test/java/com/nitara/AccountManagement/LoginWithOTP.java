/*
@Author: Neha Sahu
This test case is used to verify if User can Login with OTP.
*/
package com.nitara.AccountManagement;

import org.testng.annotations.Test;

import com.nitara.GenericBase.GenericBase;
import com.nitara.PageObjects.LoginWithOTP_Page;

public class LoginWithOTP extends GenericBase {
     @Test
     public void LoginWithOTP() throws Exception{
    	 
    	 // Create an object of LoginWithOTP page
    	 LoginWithOTP_Page login = new  LoginWithOTP_Page ();
    	 
    	 //Login with entering Phone No and OTP
    	 login.enterPhoneNo("4444444447");
    	 login.click_ContinueBtn();
    	 login.click_LoginOTPBtn();
    	 Thread.sleep(8000);
    	 login.enterOTP();
    	 login.click_LoginBtn();
    	 
    	 // Used assert to verify the user is logged in successfully to the homePage
    	 login.assert_Register();
     }
}
