package com.nitara.PageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginWithOTP_Page extends BasePage {
	
	@AndroidFindBy( id = "com.nitara.farmer:id/editTextPhone")
	private MobileElement phoneNo;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/continue_button")
	private MobileElement continueBtn;
	
	@AndroidFindBy(id = "com.nitara.farmer:id/loginWithOtpTv")
	private MobileElement LoginOTPBtn;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/otp_txt1")
	private MobileElement txt1;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/otp_txt2")
	private MobileElement txt2;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/otp_txt3")
	private MobileElement txt3;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/otp_txt4")
	private MobileElement txt4;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/continue_button")
	private MobileElement loginBtn;
	
	@AndroidFindBy( id = "com.nitara.farmer:id/textView52")
	private MobileElement assertcheck;
	
	public void enterPhoneNo(String number) {
		waitVisibility(phoneNo);
		sendKeys(phoneNo, number);
	}
	
	public void click_ContinueBtn() {
		click(continueBtn);
	}
	
	public void click_LoginOTPBtn() {
		waitVisibility(LoginOTPBtn);
		click(LoginOTPBtn);
	}
	public void enterOTP() {
		sendKeys(txt1, "1");
		sendKeys(txt2, "1");
		sendKeys(txt3, "1");
		sendKeys(txt4, "1");
		hideKeyboard();
	}
	
	public void click_LoginBtn() {
		click(loginBtn);
	}
	 public void assert_Register() {
		 waitVisibility(assertcheck);
		 Assert.assertEquals(assertcheck.getText(), "Register a cattle");
	 }
}
