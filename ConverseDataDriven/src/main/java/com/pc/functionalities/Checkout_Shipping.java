package com.pc.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pc.generalUtilities.baseTest;

public class Checkout_Shipping extends baseTest {
	public static void addShippingAddress() {

		By fName = By.xpath("//input[contains(@id,'firstName')]");
		By lName = By.xpath("//input[contains(@id,'lastName')]");
		By streetNumber = By.xpath("//input[contains(@id,'address1')]");
		By city = By.xpath("//input[contains(@id,'city')]");
		By zip = By.xpath("//div[@class='form-row']//div[@class='form-group form-column-right postal-code']//input[contains(@id,'postal') or contains(@id,'zip')]");
		By country = By.xpath("//*[contains(@id,'country')]");
		By state = By.xpath("//select[contains(@id,'state')]");
		By phone = By.xpath("//input[contains(@id,'phone')]");
		By nextToBilling = By.xpath("//*[@type='submit'][contains(@name,'shippingAddress_save')]");
		By nextToBillingUS = By.xpath("//button[@id='shipping-submit']");

		// Shipping page address*****

		// Enter first name
		(driver.findElement(fName)).sendKeys(firstName);

		// Enter last name
		(driver.findElement(lName)).sendKeys(lastName);

		// Enter street number
		driver.findElement(streetNumber).sendKeys(address1);

		// Enter city
		(driver.findElement(city)).sendKeys(cityName);

		// verify country
		countryName = driver.findElement(country).getAttribute("value");
		System.out.println(countryName);

		// Enter zip
		(driver.findElement(zip)).sendKeys(zipcode);

		try {

			boolean stat = driver.findElement(state).isDisplayed();
			if (stat) {
				// select state
				Select stateDropdown = new Select(driver.findElement(state));
				stateDropdown.selectByIndex(4);
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}

		// Enter phone number
		(driver.findElement(phone)).sendKeys(phoneNum);

		// click next to billing us
		driver.findElement(nextToBilling).click();

	}
}
