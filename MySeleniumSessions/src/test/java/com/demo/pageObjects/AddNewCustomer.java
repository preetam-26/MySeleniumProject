package com.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver ldriver;
	public AddNewCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement linkAddNewCustomer;
	
	@FindBy(name="name")
	WebElement customerName;
	
	@FindBy(name="rad1")
	WebElement customerGender;
	
	@FindBy(name="dob")
	WebElement customerDob;
	
	@FindBy(name="addr")
	WebElement CustomerAddr;
	
	@FindBy(name="city")
	WebElement CustomerCity;
	
	@FindBy(name="state")
	WebElement CustomerState;
	
	@FindBy(name="pinno")
	WebElement CustomerPinno;
	
	@FindBy(name="telephoneno")
	WebElement CustomerTelephoneno;
	
	@FindBy(name="emailid")
	WebElement CustomerEmailid;
	
	@FindBy(name="password")
	WebElement CustomerPassword;
	
	@FindBy(name="sub")
	WebElement submitBtn;
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void customerName(String cname) {
		customerName.sendKeys(cname);;
	}
	
	public void customerGender(String cgender) {
		customerGender.sendKeys(cgender);
	}
	
	public void customerDob(String mm, String dd, String yy) {
		customerDob.sendKeys(mm);
		customerDob.sendKeys(dd);
		customerDob.sendKeys(yy);
	}
	
	public void customerAddress(String caddress) {
		CustomerAddr.sendKeys(caddress);
	}
	
	public void customerCity(String ccity) {
		CustomerCity.sendKeys(ccity);
	}
	
	public void customerState(String cstate) {
		CustomerState.sendKeys(cstate);
	}
	
	public void customerPin(String cpin) {
		CustomerPinno.sendKeys(String.valueOf(cpin));
	}
	
	public void customerTelephone(String ctelephone) {
		CustomerTelephoneno.sendKeys(ctelephone);
	}
	
	public void customerEmailid(String cemailid) {
		CustomerEmailid.sendKeys(cemailid);
	}
	
	public void customerPassword(String cpassword) {
		CustomerPassword.sendKeys(cpassword);
	}
	
	public void customerSubmit() {
		submitBtn.click();
	}

}
