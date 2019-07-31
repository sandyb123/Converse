package com.pc.functionalities;

import org.openqa.selenium.By;

import com.pc.generalUtilities.baseTest;

public class Cart  extends baseTest{

	public static void minicartAndCart() {
		
		By miniCart = By.id("mini-cart");
		By proceedtoCheckout = By.xpath("//button[@class='checkout-button button']");
		
		//Mini Cart and Cart
	
			// click minicart
			(driver.findElement(miniCart)).click();
			
			// click proceed to checkout
			(driver.findElement(proceedtoCheckout)).click();
			
	}
}
