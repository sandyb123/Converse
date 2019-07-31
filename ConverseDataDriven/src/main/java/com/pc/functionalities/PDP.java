package com.pc.functionalities;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.pc.generalUtilities.baseTest;

public class PDP extends baseTest{

	public static void gotoDirectPDP1() throws IOException {
		
		driver.get(URL1);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void gotoDirectPDP2() throws IOException {
		
		driver.get(URL2);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void gotoDirectPDP1uk() throws IOException {
		
		getURL(locale);
		//driver.get(URL1);
		String uname = "storefront";
		String pwd = "Converse_2018";
		
		String URL = "https://" + uname + ":" + pwd + "@" + URL1;
		  driver.get(URL);
		
	}
	
	public static void gotoDirectPDP2uk() throws IOException {
		getURL(locale);
		String uname = "storefront";
		String pwd = "Converse_2018";
		
		String URL = "https://" + uname + ":" + pwd + "@" + URL2;
		  driver.get(URL);
		
	}
	
	
	
	
	public static void PDPselectVariant() throws InterruptedException {
		
		
		By sizeVar=By.id("sizes");
		
		
				// select the variant
				Select varDropdown = new Select(driver.findElement(sizeVar));
				varDropdown.selectByIndex(4);
				

				Thread.sleep(3000);
	}
	
	public static void scrollUK() {
				//scroll inside scroll bar
				EventFiringWebDriver evn=new EventFiringWebDriver(driver);
				evn.executeScript("document.querySelector('#pdpMain > div.regular.hc > div.product-detail--title__reverse.pdp > div > section').scrollTop = 300");
	}
	
	public static void scrollUS() {
		//scroll inside scroll bar
		EventFiringWebDriver evn=new EventFiringWebDriver(driver);
		evn.executeScript("document.querySelector('#pdpMain > div.max-width--large.gutter--normal > div > div.pdp-primary-information.pdp-primary-information--pdp.fixit-container.col-12.col-md-5.col-lg-4').scrollTop = 300");
}
	
	
	
	public static void addtoCart() throws InterruptedException {
		
		By addToCart = By.xpath("//span[@id='pdp-select-msg']");
		
		
		

		
				// Click on add to cart
		driver.findElement(By.xpath("//button[contains(@id,'add-to-cart')][1]")).click();
			//	(driver.findElement(addToCart)).click();

				Thread.sleep(3000);
	}
	
}
