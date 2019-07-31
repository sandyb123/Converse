package com.pc.functionalities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pc.generalUtilities.baseTest;

public class Checkout_Billing extends baseTest {

	public static void sameasbilling() throws InterruptedException {

		By sameasShippingAddress = By.cssSelector(
				"#primary > div.checkout-step__content > div.checkout-step__section--initial > div.form-row.form-row--reduce-spacing.form-row--choice > div > label");

		// check same as shipping address checkbox

		try {
			boolean sameasship = driver.findElement(sameasShippingAddress).isDisplayed();
			if (sameasship) {
				driver.findElement(sameasShippingAddress).click();

			}

		}

		catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void enterEmail() {

		By emailxpath = By.xpath("//input[@id='dwfrm_billing_billingAddress_email_emailAddress']");
		// enter email
		(driver.findElement(emailxpath)).sendKeys(email);

	}

	public static void clickCreditCardLink() {
		By creditCardLink = By.xpath(
				"//label[@class='payment-method__label flex flex-direction-col flex-justify-center CREDIT_CARD']");
		// Click the creditcard link
		driver.findElement(creditCardLink).click();
	}

	public static void enterCardDeatails() throws InterruptedException, IOException {

		By creditCardNumber = By.xpath("//input[contains(@id,'creditCard_number')]");
		By expiryMonthDropdown = By.xpath("//select[contains(@id,'_month')][contains(@name,'creditCard')]");
		By expiryMonth = By.xpath("(//ul[@class='select2-results__options']//li)[10]");
		By expiryYearDropdown = By.xpath("//select[contains(@id,'_year')][contains(@name,'creditCard')]");
		By expiryYear = By.xpath("//li[contains(text(),'2020')]");
		By cvvxpath = By.xpath("//input[contains(@id,'creditCard_cvn')]");
		By cardHolername = By.xpath("//input[@id='creditCard_owner']");
		By cardTypeDropdown=By.xpath("//select[contains(@id,'creditCard_type')]");

		getCardDetails(CardType);
		
		// Add card details
		
		
		//select card type
		Select ctypedropdown = new Select(driver.findElement(cardTypeDropdown));
		ctypedropdown.selectByValue(cardTypeName);
		
		// Enter card numbers
		(driver.findElement(creditCardNumber)).sendKeys(cardNumber);

		Select monDropdown = new Select(driver.findElement(expiryMonthDropdown));
		monDropdown.selectByValue(expMonth);

		Thread.sleep(2000);

		// click expiry year

		Select yearDrpdown = new Select(driver.findElement(expiryYearDropdown));
		yearDrpdown.selectByValue(expYear);

		// enter cvv
		(driver.findElement(cvvxpath)).sendKeys(cvv);

		// Enter card holder name
		try {
			if (true == driver.findElement(cardHolername).isDisplayed()) {
				driver.findElement(cardHolername).sendKeys(cardHolderName);
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	public static void clickPaypalRaadioButton() {
		By paypalRadioButton=By.xpath("//input[@id='is-PAY_PAL']");
		driver.findElement(paypalRadioButton).click();
	}
	
	public static void enterPaypalDeatils() {
		
		
		By loginButton=By.xpath("//input[@id='btnLogin']");
		By paynow=By.xpath("//input[@id='continue_abovefold']");
		driver.findElement(loginButton).click();
		driver.findElement(paynow).click();
	}
	
	public static void enterPaypalDetailsDE() throws InterruptedException, IOException {
		By username = By.xpath("//input[@id='email']");
		By pwd = By.xpath("//input[@id='password']");
		By loginButton = By.xpath("//button[@id='btnLogin']");
		By continueButton = By.xpath("//div[@id='button']//button");
		By confirmButton = By.xpath("//input[@id='confirmButtonTop']");

		getCardDetails(CardType);
		try {
			boolean LoginPagevisible = driver.findElement(username).isDisplayed();
			if (LoginPagevisible == true) {
				driver.findElement(username).sendKeys(Paypalusername);
				driver.findElement(pwd).sendKeys(Paypalpwd);
				driver.findElement(loginButton).click();
				Thread.sleep(3000);
				driver.findElement(continueButton).click();
				Thread.sleep(2000);
				driver.findElement(confirmButton).click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			driver.findElement(continueButton).click();
			Thread.sleep(2000);
			driver.findElement(confirmButton).click();
		}

	}

	public static void enterConfirmMail() {
		By confirmEmail = By.xpath("//input[@id='dwfrm_billing_billingAddress_email_confirmationEmailAddress']");
		// enter confirm email
		(driver.findElement(confirmEmail)).sendKeys(email);
	}

	public static void enterPhoneNumber() {

	}

	public static void clickNexttoOrderReview() {
		By nextOrderreview = By.xpath("//button[@class='btn-continue'][@type='submit']");
		// click next to order review
		(driver.findElement(nextOrderreview)).click();
	}

	public static void addBillingAddress() {
		By cardNumb = By.xpath("//input[contains(@id,'creditCard_number')]");

	}

	public static void billingPageUK() throws InterruptedException, IOException {
		
		if(!CardType.equalsIgnoreCase("Paypal")) {
		enterCardDeatails();
		}
		else {
			clickPaypalRaadioButton();
		}
		enterEmail();
		enterConfirmMail();
		clickNexttoOrderReview();
		

	}
	
	/*
	 * public static void billingPageUKPaypal() { clickPaypalRaadioButton();
	 * enterEmail(); enterConfirmMail(); clickNexttoOrderReview(); }
	 */

	public static void billingPageUS() throws InterruptedException, IOException {
		sameasbilling();
		enterEmail();

		clickCreditCardLink();
		enterCardDeatails();
		clickNexttoOrderReview();

	}
}
