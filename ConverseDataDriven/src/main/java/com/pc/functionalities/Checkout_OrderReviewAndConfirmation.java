package com.pc.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Reporter;

import com.pc.generalUtilities.baseTest;

public class Checkout_OrderReviewAndConfirmation extends baseTest{
	
	public static void orderreview() throws InterruptedException {
		By orderAndPay = By.xpath("//button[@type='submit'][@name='submit']");
		By checkbox = By.xpath("//span[@class='styled-checkbox']");
		
		By closeicon =By.xpath("//button[@class='window-modal__close']");
		
		//Order review and Order confirmation
		
		
				

		
		  // selct check box 
		try {
			boolean chk = driver.findElement(checkbox).isDisplayed();
		if (chk) {
			(driver.findElement(checkbox)).click();
		}

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		 

				// click order and pay
				(driver.findElement(orderAndPay)).click();
				
				Thread.sleep(3000);
				
				try {
					boolean cls = driver.findElement(closeicon).isDisplayed();
					if(cls) {
						driver.findElement(closeicon).click();
						
					}
				}
					
					catch (Exception e) {
						// TODO: handle exception
					}
							
			
				
	}		

	public static void getOrderNumberUS() {
		By orderNumber = By.xpath("//*[@class='order-details__header-title text--semibold']");
				// get order number
				String Order = (driver.findElement(orderNumber)).getText();
				System.out.println(Order);
	}
	
	public static void getOrderNumberUK() {
		By orderNumber = By.xpath("//*[@class='checkout-order-number']/span");
		// get order number
		String Order = (driver.findElement(orderNumber)).getText();
		System.out.println(locale +":"+ CardType + ":" +Order);
		Reporter.log(locale +":"+ CardType + ":" +Order);
	}
	

}
