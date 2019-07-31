package com.pc.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pc.generalUtilities.baseTest;

public class Home_CLP_PLP extends baseTest {

	public static void selectLocale() {
		By locale = By.xpath("//div[@class='header-country-selector']//span[1]");
		By localeBelgium = By.xpath("//div[contains(text(),'Belgium')]");
		By localeBelgique = By.xpath("//div[contains(text(),'Belgique')]");
		By localeBelgie = By.xpath("//div[contains(text(),'België')]");		
		
		//Locale interaction
		
				// Click on locale
				// driver.findElement(locale).click();

				// Select the country required
				driver.findElement(localeBelgium).click();
	}
	
	public static void acceptCookies() {
		By acceptCookie = By.xpath(
				"//div[@class='popUp-Cookies cookie-popUp-view']//button[@type='button'][contains(text(),'Yes, I accept')]");
		By dateModalClose = By.xpath("//button[@title='Close (Esc)']");
		
		//Accept cookies and date model handle
		
				// accept cookies
				driver.findElement(acceptCookie).click();

				// close date model
				driver.findElement(dateModalClose).click();
	}
	
	public static void navigations() {
		By categoryID = By.xpath("//li[@id='Women-container']");
		By subcategoryID = By.xpath(
				"//div[@class='external-category-container clicked expanded']//a[contains(text(),'All Sneakers')]");
		By productId = By.xpath("(//div[@class='product-name']//a)[1]");
		
		//Home_CLP_PLP
		
				// Hover on category
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(categoryID)).build().perform();

				// Click on subcategory
				driver.findElement(subcategoryID).click();

				// click on 1st product
				driver.findElement(productId).click();
	}
	
	
}
