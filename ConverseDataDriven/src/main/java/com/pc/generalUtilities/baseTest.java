package com.pc.generalUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.pc.functionalities.Cart;

public class baseTest {
	
	public String chromePath="\\resources\\drivers\\chromedriver.exe";
	public String firefoxPath = "\\resources\\drivers\\geckodriver.exe";
	public String iePath = "\\resources\\drivers\\IEDriverServer.exe";
	
	public static WebDriver driver;
	
	public static String countryName;
	public static String URL1;
	public static String URL2;
	public static String basketId;
	public static  int localepostion, Cardposition;
	public static String locale;
	public static int totalRow, totalCardType, totalCard;
	public static String expYear, expMonth, cvv, cardTypeName, cardNumber, cardHolderName, CardType, zipcode, firstName,lastName,cityName,state,phoneNum,address1,email,Paypalusername,Paypalpwd;
	
	
	 
	
	
	@BeforeClass
	@Parameters("browser")
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+chromePath);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+firefoxPath);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+iePath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void maxwindow() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	
	public static void closeWindowPopup() {
		try {
		By windowClose=By.xpath("//button[@class='window-modal__close']");
		driver.findElement(windowClose).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void accptCookie() {
		try {
			By acceptCookieButton=By.xpath("//div[@class='popUp-Cookies cookie-popUp-view']//button[@type='button'][@class='button accept-button']");
			boolean actCookie = driver.findElement(acceptCookieButton).isDisplayed();
			if(actCookie) {
				driver.findElement(acceptCookieButton).click();
			}
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	public static String getLocale() throws IOException {
		ArrayList<String> localeData = Fetchdata.getLocaleInfo("//src//main//java//com//pc//generalUtilities//orders.xlsx", "OrderPlacementDetails");
		
		locale = localeData.get(localepostion);
		System.out.println(locale);
		return locale;
	}
	
	public static String getCardType() throws IOException {
		ArrayList<String> localeData = Fetchdata.getcardInfo("//src//main//java//com//pc//generalUtilities//orders.xlsx", "CardNumber");
		
		CardType = localeData.get(Cardposition);
		System.out.println(CardType);
		return CardType;
	}
	
	public static void getURL(String locale) throws IOException {
		 locale=baseTest.locale;
		
		 ArrayList<String> data = Fetchdata.excelData("//src//main//java//com//pc//generalUtilities//orders.xlsx", "OrderPlacementDetails", locale);
		
		
	URL1 = data.get(1);
	URL2 = data.get(2);
	zipcode=data.get(13);
	firstName=data.get(9);
	lastName=data.get(10);
	cityName=data.get(11);
	state=data.get(12);
	phoneNum=data.get(14);
	address1=data.get(15);
	email=data.get(18);
	
		
	}
	
	public static void getCardDetails(String CardType) throws IOException {
		ArrayList<String> data = Fetchdata.cardData("//src//main//java//com//pc//generalUtilities//orders.xlsx", "CardNumber", CardType);
		cardTypeName=data.get(0);
		cardNumber=data.get(1);
		cardHolderName=data.get(2);
		expMonth=data.get(3);
		expYear=data.get(4);
		cvv=data.get(5);
		Paypalusername=data.get(1);
		Paypalpwd=data.get(2);
		
	}
	

	
}
