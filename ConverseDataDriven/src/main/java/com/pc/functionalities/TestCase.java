package com.pc.functionalities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.text.Document;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pc.generalUtilities.Fetchdata;
import com.pc.generalUtilities.baseTest;

public class TestCase extends baseTest {

	
	public static void gotocategory() {
		Home_CLP_PLP.selectLocale();
		Home_CLP_PLP.acceptCookies();
		Home_CLP_PLP.navigations();
	}
	
	
	
	
	public static void PDPus() throws InterruptedException, IOException {
		
		PDP.gotoDirectPDP1();
		// maximize window
		maxwindow();
		// Close window
		closeWindowPopup();
		PDP.scrollUS();
		PDP.addtoCart();
		PDP.gotoDirectPDP2();
		PDP.scrollUS();
		PDP.addtoCart();
	}

	
	public static void PDPuk() throws InterruptedException, IOException {

		PDP.gotoDirectPDP1uk();
		accptCookie();
		Thread.sleep(2000);
		maxwindow();
		PDP.PDPselectVariant();
		PDP.scrollUK();
		PDP.addtoCart();
		PDP.gotoDirectPDP2uk();
		PDP.PDPselectVariant();
		PDP.scrollUK();
		PDP.addtoCart();

	}

	
	public static void cart() {
		Cart.minicartAndCart();
	}

	
	public static void checkoutBillingPaypal() throws InterruptedException, IOException {
		Checkout_Shipping.addShippingAddress();
		if (countryName.equalsIgnoreCase("United States")) {
			Checkout_Billing.billingPageUS();
		} else {
			//Checkout_Billing.billingPageUKcreditCard();
			Checkout_Billing.billingPageUK();
		}
	}
	
	public static void checkoutBilling() throws InterruptedException, IOException {
		Checkout_Shipping.addShippingAddress();
		if (countryName.equalsIgnoreCase("United States")) {
			Checkout_Billing.billingPageUS();
		} else {
			//Checkout_Billing.billingPageUKcreditCard();
			Checkout_Billing.billingPageUK();
		}
	}
	
	
		
		
		
	public static void getOrderIds() {
		if (countryName.equalsIgnoreCase("United States")) {
			Checkout_OrderReviewAndConfirmation.getOrderNumberUS();
		}
		
		
		else {
			Checkout_OrderReviewAndConfirmation.getOrderNumberUK();
		}
		
	}
		
		
		
		
	
	
	@Test(enabled=false)
	public static void orderPlacementUS() throws InterruptedException, IOException {
		PDPus();
		cart();
		checkoutBilling();
		Checkout_OrderReviewAndConfirmation.orderreview();
		getOrderIds();
	}
	
	@Test(priority=1)
	public static void orderPlacementEU() throws InterruptedException, IOException {
		ArrayList<String> localeData = Fetchdata.getLocaleInfo("//src//main//java//com//pc//generalUtilities//orders.xlsx", "OrderPlacementDetails");
		for(localepostion=4;localepostion<=totalRow;localepostion++) {
			
			
			getLocale();
			ArrayList<String> localeData2 = Fetchdata.getcardInfo("//src//main//java//com//pc//generalUtilities//orders.xlsx", "CardNumber");
				try {
			for (Cardposition=1;Cardposition<=totalCard;Cardposition++) {
				
			getCardType();
			
		
			PDPuk();
		
			cart();
			
			
			checkoutBilling();
			
		
			Checkout_OrderReviewAndConfirmation.orderreview();
			
			
			if(CardType.equalsIgnoreCase("Paypal")) {
			if(locale.equalsIgnoreCase("DE-EN") ||  locale.equalsIgnoreCase("DE-DE") ) {
				Thread.sleep(3000);
				Checkout_Billing.enterPaypalDetailsDE();
			}
			else {
				Checkout_Billing.enterPaypalDeatils();
			}
			}
			
			
			
			else {
				
				
			}
		
			getOrderIds();
			}
				}
				
				catch (Exception e) {
					// TODO: handle exception
					File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("C:\\Users\\sandeepa.bhat\\git\\seleniumPractice\\sampleProject\\src\\main\\java\\com\\pc\\generalUtilities" + System.currentTimeMillis()+".png"));
					Reporter.log(locale +":"+ CardType + ":" + e.getMessage());
					System.out.println(locale +":"+ CardType + ":"+e.getMessage());
				}
				
				
		
		}
	}
	
	@Test(enabled=false)
	public static void orderPlacementEUPaypal() throws InterruptedException, IOException {
		ArrayList<String> localeData = Fetchdata.getLocaleInfo("//src//main//java//com//pc//generalUtilities//orders.xlsx", "OrderPlacementDetails");
		for(localepostion=2;localepostion<=totalRow;localepostion++) {
		getLocale();
		PDPuk();
		cart();
		checkoutBillingPaypal();
		Checkout_OrderReviewAndConfirmation.orderreview();
		Checkout_Billing.enterPaypalDeatils();
		getOrderIds();
		
		
		
		}
	}

}
